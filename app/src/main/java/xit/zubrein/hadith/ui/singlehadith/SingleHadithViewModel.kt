package xit.zubrein.hadith.ui.singlehadith

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import xit.zubrein.hadith.ui.chapter.ChapterRepository
import xit.zubrein.hadith.ui.chapter.listener.ChapterListener
import xit.zubrein.hadith.ui.hadithlist.listener.HadithListListener
import xit.zubrein.hadith.ui.singlehadith.listener.SingleHadithListener
import javax.inject.Inject

@HiltViewModel
class SingleHadithViewModel
@Inject
constructor(
    private val repository: SingleHadithRepository
) : ViewModel() {
    private val TAG = "SingleHadithViewModel"

    var listener : SingleHadithListener? = null

    fun getHadith(collectionName : String,hadithNumber : String){

        listener?.OnStart()

        val hadith = repository.getHadith(collectionName,hadithNumber).asLiveData()

        listener?.onReceived(hadith)

    }


}