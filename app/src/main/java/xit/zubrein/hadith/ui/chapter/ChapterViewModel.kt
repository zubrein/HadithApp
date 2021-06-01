package xit.zubrein.hadith.ui.chapter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.ui.chapter.listener.ChapterListener
import xit.zubrein.hadith.ui.collection.listener.CollectionListener
import javax.inject.Inject

@HiltViewModel
class ChapterViewModel
@Inject
constructor(
     private val repository: ChapterRepository
) : ViewModel() {
    private val TAG = "CollectionViewModel"
    var chapterListener : ChapterListener? = null

    fun getChapters(collectionName : String){

        chapterListener?.chapterOnStart()

        val chapters = repository.getChapters(collectionName).catch {
            e ->
            Log.d(TAG, "getCollections: ${e.message}")
            e.message?.let {
                chapterListener?.chapterDidFailed(it)
            }
        }.asLiveData()

        chapterListener?.chapterOnReceived(chapters)

    }


}