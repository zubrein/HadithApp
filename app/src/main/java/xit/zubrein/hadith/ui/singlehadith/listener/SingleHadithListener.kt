package xit.zubrein.hadith.ui.singlehadith.listener

import androidx.lifecycle.LiveData
import xit.zubrein.hadith.Utils.cacheutils.Resource
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.model.SingleHadith

interface SingleHadithListener {

    fun OnStart()

    fun onReceived(hadith : LiveData<Resource<SingleHadith>>)

    fun failed(message : String)

}