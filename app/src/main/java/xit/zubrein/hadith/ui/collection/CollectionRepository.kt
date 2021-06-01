package xit.zubrein.hadith.ui.collection

import androidx.room.withTransaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xit.zubrein.hadith.Utils.cacheutils.networkBoundResource
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.network.apis.ApiService
import xit.zubrein.hadith.room.AppDatabase
import javax.inject.Inject

class CollectionRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val db : AppDatabase
    ) {

    private  val dao = db.booksDao()


     fun getBooks() = networkBoundResource(
        query = {
            dao.getAllCollections()
        },
        fetch = {
            apiService.getCollections()
        },
        saveFetchResult = {
            val list = it.data
            db.withTransaction {
                dao.deleteAllCollections()
                for(item in list) {
                    dao.insert(item)
                }
            }
        }
    )
    
}