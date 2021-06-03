package xit.zubrein.hadith.network.apis

import retrofit2.http.GET
import retrofit2.http.Path
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.model.ModelHadith
import xit.zubrein.hadith.model.SingleHadith
import xit.zubrein.hadith.network.data.ApiConstants

interface ApiService {

    @GET(ApiConstants.COLLECTIONS)
    suspend fun getCollections() : ModelCollections

    @GET(ApiConstants.CHAPTERS)
    suspend fun getChapters(
        @Path("collectionName") collectionName: String
    ) : ModelChapter

    @GET(ApiConstants.HADITH_LIST)
    suspend fun getHadithList(
        @Path("collectionName") collectionName: String,
        @Path("bookNumber") bookNumber: String,
    ) : ModelHadith

    @GET(ApiConstants.SINGLE_HADITH)
    suspend fun getSingleHadith(
        @Path("collectionName") collectionName: String,
        @Path("hadithNumber") hadithNumber: String,
    ) : SingleHadith



}