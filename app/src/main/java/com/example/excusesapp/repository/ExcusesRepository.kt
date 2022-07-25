package com.example.excusesapp.repository

import com.example.excusesapp.api.ExcusesServiceApi
import com.example.excusesapp.model.ExcusesResponse
import retrofit2.Response
import javax.inject.Inject

interface ExcusesRepository {
    suspend fun getAllExcuses(): Response<ExcusesResponse>
    suspend fun getOfficeExcuses(): Response<ExcusesResponse>
    suspend fun getFamilyExcuses(): Response<ExcusesResponse>
    suspend fun getChildrenExcuses(): Response<ExcusesResponse>
    suspend fun getCollegeExcuses(): Response<ExcusesResponse>
    suspend fun getPartyExcuses(): Response<ExcusesResponse>
}

class ExcusesRepositoryImpl @Inject constructor(
    private val excusesServiceApi: ExcusesServiceApi
        ) : ExcusesRepository{
    override suspend fun getAllExcuses(): Response<ExcusesResponse> {
        return excusesServiceApi.getAllExcuses()
    }

    override suspend fun getOfficeExcuses(): Response<ExcusesResponse> {
        return excusesServiceApi.getOfficeExcuses()
    }

    override suspend fun getFamilyExcuses(): Response<ExcusesResponse> {
        return excusesServiceApi.getFamilyExcuses()
    }

    override suspend fun getChildrenExcuses(): Response<ExcusesResponse> {
        return excusesServiceApi.getChildrenExcuses()
    }

    override suspend fun getCollegeExcuses(): Response<ExcusesResponse> {
        return excusesServiceApi.getCollegeExcuses()
    }

    override suspend fun getPartyExcuses(): Response<ExcusesResponse> {
        return excusesServiceApi.getPartyExcuses()
    }

}