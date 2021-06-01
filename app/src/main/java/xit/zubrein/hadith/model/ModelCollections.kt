package xit.zubrein.hadith.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson


typealias Details = ModelDetails

data class ModelCollections(
    var data: List<ModelBooks>
) {
    @Entity(tableName = "books")
    data class ModelBooks(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var name: String,
        var hasBooks: Boolean,
        var hasChapters: Boolean,
        var collection: List<ModelDetails>?
    )
}
data class ModelDetails(
    @PrimaryKey
    var lang: String,
    var title: String,
    var shortIntro: String,
)

class CollectionConverter {

    @TypeConverter
    fun listToJson(value: List<Details>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value : String) = Gson().fromJson(value, Array<Details>::class.java).toList()
}
