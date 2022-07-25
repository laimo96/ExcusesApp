package com.example.excusesapp.api

import com.example.excusesapp.model.ExcusesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ExcusesServiceApi {

    @GET(ALL_URL)
    suspend fun getAllExcuses(): Response<ExcusesResponse>

    @GET(OFFICE_URL)
    suspend fun getOfficeExcuses(): Response<ExcusesResponse>

    @GET(FAMILY_URL)
    suspend fun getFamilyExcuses(): Response<ExcusesResponse>

    @GET(CHILDREN_URL)
    suspend fun getChildrenExcuses(): Response<ExcusesResponse>

    @GET(COLLEGE_URL)
    suspend fun getCollegeExcuses(): Response<ExcusesResponse>

    @GET(PARTY_URL)
    suspend fun getPartyExcuses(): Response<ExcusesResponse>

    companion object{
        const val BASE_URL = "https://excuser.herokuapp.com/v1/excuse/"
        private const val ALL_URL = "410"
        private const val OFFICE_URL = "office/100"
        private const val FAMILY_URL = "family/100"
        private const val CHILDREN_URL = "children/100"
        private const val COLLEGE_URL = "college/100"
        private const val PARTY_URL = "party/100"

    }
}