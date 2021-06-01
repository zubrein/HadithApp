package xit.zubrein.hadith.ui.collection.listener

import androidx.lifecycle.LiveData
import xit.zubrein.hadith.Utils.cacheutils.Resource
import xit.zubrein.hadith.model.ModelCollections

interface CollectionListener {

    fun collectionOnStart()

    fun collectionOnReceived(collections : LiveData<Resource<ModelCollections>>)

    fun collectionDidFailed(message : String)

}