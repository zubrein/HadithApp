package xit.zubrein.hadith.ui.hadithlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import xit.zubrein.hadith.ui.chapter.ChapterRepository
import xit.zubrein.hadith.ui.chapter.listener.ChapterListener
import xit.zubrein.hadith.ui.hadithlist.listener.HadithListListener
import javax.inject.Inject

@HiltViewModel
class HadithListViewModel
@Inject
constructor(
    private val repository: HadithListRepository
) : ViewModel() {
    private val TAG = "CollectionViewModel"
    var listListener : HadithListListener? = null

    fun getHadithList(collectionName : String,bookNumber : String){

        listListener?.HadithListOnStart()

        val chapters = repository.getHadithList(collectionName,bookNumber).asLiveData()

        listListener?.HadithListOnReceived(chapters)

    }


}