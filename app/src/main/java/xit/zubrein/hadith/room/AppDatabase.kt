package xit.zubrein.hadith.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import xit.zubrein.hadith.model.CollectionConverter
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.room.dao.BooksDao


@Database(entities = [ModelCollections.ModelBooks::class],version = 1, exportSchema = false)
@TypeConverters(CollectionConverter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun booksDao(): BooksDao
}