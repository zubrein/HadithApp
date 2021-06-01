package xit.zubrein.hadith.ui.collection

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.ui.collection.listener.CollectionListener
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel
@Inject
constructor(
     private val repository: CollectionRepository
) : ViewModel() {
    private val TAG = "CollectionViewModel"
    var collectionListener : CollectionListener? = null

    fun getCollections(){

        collectionListener?.collectionOnStart()

        val collections = repository.getBooks().asLiveData()

        collectionListener?.collectionOnReceived(collections)

    }


}