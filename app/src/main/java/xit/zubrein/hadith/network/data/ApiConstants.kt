package xit.zubrein.hadith.network.data

object ApiConstants {

    //BaseAPIs
    const val BASE_URL = "https://api.sunnah.com/"
    const val VERSION = "v1/"
    const val KEY = "SqD712P3E82xnwOAEOkGd5JZH8s9wRR24TqNFzjk"

    //collections
    const val COLLECTIONS = "collections"

    //Chapters
    const val CHAPTERS = "collections/{collectionName}/books"

    //HadithList
    const val HADITH_LIST = "$CHAPTERS/{bookNumber}/hadiths"

    //SingleHadith
    const val SINGLE_HADITH = "collections/{collectionName}/hadiths/{hadithNumber}"

}