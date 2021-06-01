package xit.zubrein.hadith.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

@Entity(tableName = "chapter")
data class ModelChapter(
    @PrimaryKey
    @SerializedName("ref")
    var ref: String,
    @SerializedName("data")
    val data: List<Chapter>
)
data class Chapter(
    @SerializedName("bookNumber")
    val bookNumber: String,
    @SerializedName("book")
    val book: List<Book>,
    @SerializedName("hadithStartNumber")
    val hadithStartNumber: Int,
    @SerializedName("hadithEndNumber")
    val hadithEndNumber: Int,
    @SerializedName("numberOfHadith")
    val numberOfHadith: Int
)

data class Book(
    @SerializedName("lang")
    val lang: String,
    @SerializedName("name")
    val name: String?
)


class ChapterTypeConverter{

    @TypeConverter
    fun ChapterListToJson(value: List<Chapter>) = Gson().toJson(value)

    @TypeConverter
    fun ChapterJsonToList(value : String) = Gson().fromJson(value, Array<Chapter>::class.java).toList()

    @TypeConverter
    fun BookListToJson(value: List<Book>) = Gson().toJson(value)

    @TypeConverter
    fun BookJsonToList(value : String) = Gson().fromJson(value, Array<Book>::class.java).toList()


}