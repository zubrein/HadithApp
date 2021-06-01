package xit.zubrein.hadith.ui.chapter

import androidx.room.withTransaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xit.zubrein.hadith.Utils.cacheutils.networkBoundResource
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.network.apis.ApiService
import xit.zubrein.hadith.room.AppDatabase
import javax.inject.Inject

class ChapterRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val db: AppDatabase
) {

    private val dao = db.chapterDao()

    fun getChapters(collectionName: String) = networkBoundResource(
        query = {
            dao.getAllChapters(collectionName)
        },
        fetch = {
            delay(2000)
            apiService.getChapters(collectionName)
        },
        saveFetchResult = { response ->
            db.withTransaction {
                response.ref = collectionName
                dao.insertChapter(response)
            }

        }
    )


}