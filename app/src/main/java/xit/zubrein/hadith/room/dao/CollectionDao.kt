package xit.zubrein.hadith.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xit.zubrein.hadith.model.ModelCollections

@Dao
interface CollectionDao {

    @Query("SELECT * FROM collection")
    fun getAllCollections() : Flow<ModelCollections>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(books : ModelCollections)

    @Query("DELETE FROM collection")
    suspend fun deleteAllCollections()
}