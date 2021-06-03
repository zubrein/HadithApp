package xit.zubrein.hadith.ui.hadithlist

import androidx.room.withTransaction
import kotlinx.coroutines.delay
import xit.zubrein.hadith.Utils.cacheutils.networkBoundResource
import xit.zubrein.hadith.network.apis.ApiService
import xit.zubrein.hadith.room.AppDatabase
import javax.inject.Inject

class HadithListRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val db: AppDatabase
) {

    private val dao = db.hadithDao()

    fun getHadithList(collectionName: String,bookNumber: String) = networkBoundResource(
        query = {
            dao.getAllHadith(collectionName,bookNumber)
        },
        fetch = {
            delay(2000)
            apiService.getHadithList(collectionName,bookNumber)
        },
        saveFetchResult = { response ->
            db.withTransaction {
                response.ref = collectionName
                response.bookNumber = bookNumber
                dao.insertHadith(response)
            }

        }
    )


}