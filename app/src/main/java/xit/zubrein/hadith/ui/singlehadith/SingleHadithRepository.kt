package xit.zubrein.hadith.ui.singlehadith

import androidx.room.withTransaction
import kotlinx.coroutines.delay
import xit.zubrein.hadith.Utils.cacheutils.networkBoundResource
import xit.zubrein.hadith.network.apis.ApiService
import xit.zubrein.hadith.room.AppDatabase
import javax.inject.Inject

class SingleHadithRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val db: AppDatabase
) {

    private val dao = db.singleHadithDao()

    fun getHadith(collectionName: String,hadithNumber : String) = networkBoundResource(
        query = {
            dao.getHadith(collectionName,hadithNumber)
        },
        fetch = {
            delay(2000)
            apiService.getSingleHadith(collectionName,hadithNumber)
        },
        saveFetchResult = { response ->
            db.withTransaction {
                dao.insertHadith(response)
            }

        }
    )


}