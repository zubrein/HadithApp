package xit.zubrein.hadith.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "hadith",primaryKeys = ["collection","hadithNumber"])
data class SingleHadith(
    @SerializedName("collection") val collection : String,
    @SerializedName("bookNumber") val bookNumber : Int,
    @SerializedName("chapterId") val chapterId : Double,
    @SerializedName("hadithNumber") val hadithNumber : Int,
    @SerializedName("hadith") val hadith : List<Hadith>
)


