package xit.zubrein.hadith.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xit.zubrein.hadith.model.ModelChapter

@Dao
interface ChapterDao {

    @Query("SELECT * FROM chapter WHERE ref = :collectionName")
    fun getAllChapters(collectionName : String) : Flow<ModelChapter>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChapter(chapter : ModelChapter)

    @Query("DELETE FROM chapter")
    suspend fun deleteAllChapter()
    
}