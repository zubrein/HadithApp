package xit.zubrein.hadith.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson

@Entity(tableName = "collection")
data class ModelCollections(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var data: List<ModelBooks>
)
data class ModelBooks(
    var name: String,
    var hasBooks: Boolean,
    var hasChapters: Boolean,
    var collection: List<ModelDetails>?
)
data class ModelDetails(
    var lang: String,
    var title: String,
    var shortIntro: String,
)

class CollectionConverter {

    @TypeConverter
    fun detailsListToJson(value: List<ModelDetails>) = Gson().toJson(value)

    @TypeConverter
    fun detailsJsonToList(value : String) = Gson().fromJson(value, Array<ModelDetails>::class.java).toList()

    @TypeConverter
    fun collectionListToJson(value: List<ModelBooks>) = Gson().toJson(value)

    @TypeConverter
    fun collectionJsonToList(value : String) = Gson().fromJson(value, Array<ModelBooks>::class.java).toList()


}
