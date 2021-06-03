package xit.zubrein.hadith.model

import androidx.room.Entity
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

@Entity(tableName = "hadith_list",primaryKeys = ["ref","bookNumber"])
data class ModelHadith (
    @SerializedName("data")
    val data : List<Content>,
    @SerializedName("ref")
    var ref : String,
    @SerializedName("bookNumber")
    var bookNumber : String

)

data class Content (
    @SerializedName("collection") val collection : String,
    @SerializedName("bookNumber") val bookNumber : Int,
    @SerializedName("chapterId") val chapterId : Double,
    @SerializedName("hadithNumber") val hadithNumber : Int,
    @SerializedName("hadith") val hadith : List<Hadith>
)


data class Hadith (
    @SerializedName("lang") val lang : String,
    @SerializedName("chapterNumber") val chapterNumber : Int,
    @SerializedName("chapterTitle") val chapterTitle : String,
    @SerializedName("urn") val urn : Int,
    @SerializedName("body") val body : String,
    @SerializedName("grades") val grades : List<Grades>
)

data class Grades (
    @SerializedName("graded_by") val graded_by : String,
    @SerializedName("grade") val grade : String
)

class HadithListTypeConverter{

    @TypeConverter
    fun ContentListToJson(value: List<Content>) = Gson().toJson(value)

    @TypeConverter
    fun ContentJsonToList(value : String) = Gson().fromJson(value, Array<Content>::class.java).toList()

    @TypeConverter
    fun HadithListToJson(value: List<Hadith>) = Gson().toJson(value)

    @TypeConverter
    fun HadithJsonToList(value : String) = Gson().fromJson(value, Array<Hadith>::class.java).toList()

    @TypeConverter
    fun GradesListToJson(value: List<Grades>) = Gson().toJson(value)

    @TypeConverter
    fun GradesJsonToList(value : String) = Gson().fromJson(value, Array<Grades>::class.java).toList()



}