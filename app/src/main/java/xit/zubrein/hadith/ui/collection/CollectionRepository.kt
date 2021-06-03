package xit.zubrein.hadith.ui.collection

import androidx.room.withTransaction
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import xit.zubrein.hadith.Utils.cacheutils.networkBoundResource
import xit.zubrein.hadith.network.apis.ApiService
import xit.zubrein.hadith.room.AppDatabase
import javax.inject.Inject

class CollectionRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val db : AppDatabase
    ) {

    private  val dao = db.collectionDao()


     fun getBooks() = networkBoundResource(
        query = {
            dao.getAllCollections()
        },
        fetch = {
            delay(2000)
            apiService.getCollections()
        },
        saveFetchResult = { response ->
            db.withTransaction {
                dao.deleteAllCollections()
                dao.insertCollection(response)
            }
        }
    )
    
}