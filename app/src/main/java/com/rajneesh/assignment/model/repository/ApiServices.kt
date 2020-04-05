package com.health.ness.repository

import com.rajneesh.assignment.model.WhetherResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("current")
    fun getLocationWhetherData(@Query("access_key") access_key: String, @Query("query") query: String): Observable<WhetherResponseModel>
}