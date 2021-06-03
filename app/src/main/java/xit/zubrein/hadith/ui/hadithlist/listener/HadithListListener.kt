package xit.zubrein.hadith.ui.hadithlist.listener

import androidx.lifecycle.LiveData
import xit.zubrein.hadith.Utils.cacheutils.Resource
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.model.ModelHadith

interface HadithListListener {

    fun HadithListOnStart()

    fun HadithListOnReceived(list : LiveData<Resource<ModelHadith>>)

    fun HadithListDidFailed(message : String)

}