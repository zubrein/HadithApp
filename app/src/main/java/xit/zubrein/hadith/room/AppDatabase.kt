package xit.zubrein.hadith.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import xit.zubrein.hadith.model.ChapterTypeConverter
import xit.zubrein.hadith.model.CollectionConverter
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.room.dao.ChapterDao
import xit.zubrein.hadith.room.dao.CollectionDao


@Database(entities = [ModelCollections::class, ModelChapter::class],version = 1, exportSchema = false)
@TypeConverters(CollectionConverter::class,ChapterTypeConverter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun collectionDao(): CollectionDao
    abstract fun chapterDao() : ChapterDao
}