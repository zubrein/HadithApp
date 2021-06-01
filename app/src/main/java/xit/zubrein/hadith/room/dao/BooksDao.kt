package xit.zubrein.hadith.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xit.zubrein.hadith.model.ModelCollections

@Dao
interface BooksDao {

    @Query("SELECT * FROM books")
    fun getAllCollections() : Flow<List<ModelCollections.ModelBooks>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(books : ModelCollections.ModelBooks)

    @Query("DELETE FROM books")
    suspend fun deleteAllCollections()
}