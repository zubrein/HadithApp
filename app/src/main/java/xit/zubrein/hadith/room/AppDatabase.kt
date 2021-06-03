package xit.zubrein.hadith.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import xit.zubrein.hadith.model.*
import xit.zubrein.hadith.room.dao.ChapterDao
import xit.zubrein.hadith.room.dao.CollectionDao
import xit.zubrein.hadith.room.dao.HadithListDao
import xit.zubrein.hadith.room.dao.SingleHadithDao


@Database(entities = [ModelCollections::class, ModelChapter::class, ModelHadith::class, SingleHadith::class],version = 1, exportSchema = false)
@TypeConverters(CollectionConverter::class,ChapterTypeConverter::class, HadithListTypeConverter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun collectionDao(): CollectionDao
    abstract fun chapterDao() : ChapterDao
    abstract fun hadithDao() : HadithListDao
    abstract fun singleHadithDao() : SingleHadithDao
}