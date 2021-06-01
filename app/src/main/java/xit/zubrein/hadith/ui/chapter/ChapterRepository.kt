package xit.zubrein.hadith.ui.chapter

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.network.apis.ApiService
import javax.inject.Inject

class ChapterRepository
@Inject
constructor(private val apiService: ApiService) {

    fun getChapters(collectionName : String): Flow<ModelChapter> = flow {
        val response = apiService.getChapters(collectionName)
        emit(response)
    }.flowOn(Dispatchers.IO)
    
}