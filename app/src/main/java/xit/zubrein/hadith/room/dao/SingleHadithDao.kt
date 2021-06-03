package xit.zubrein.hadith.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xit.zubrein.hadith.model.ModelHadith
import xit.zubrein.hadith.model.SingleHadith

@Dao
interface SingleHadithDao {

    @Query("SELECT * FROM hadith WHERE collection = :collectionName and hadithNumber = :hadithNumber")
    fun getHadith(collectionName : String,hadithNumber : String) : Flow<SingleHadith>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHadith(hadith : SingleHadith)

    @Query("DELETE FROM hadith")
    suspend fun deleteHadith()
    
}