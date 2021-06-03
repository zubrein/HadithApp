package xit.zubrein.hadith.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xit.zubrein.hadith.model.ModelHadith

@Dao
interface HadithListDao {

    @Query("SELECT * FROM hadith_list WHERE ref = :collectionName and bookNumber = :bookNumber")
    fun getAllHadith(collectionName : String,bookNumber : String) : Flow<ModelHadith>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHadith(hadith : ModelHadith)

    @Query("DELETE FROM hadith_list")
    suspend fun deleteAllHadith()
    
}