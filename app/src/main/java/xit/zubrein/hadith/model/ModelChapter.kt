package xit.zubrein.hadith.model

import com.google.gson.annotations.SerializedName

data class ModelChapter(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("next")
    val next: Int
) {
    data class Data(
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
    ) {
        data class Book(
            @SerializedName("lang")
            val lang: String,
            @SerializedName("name")
            val name: String?
        )
    }
}
