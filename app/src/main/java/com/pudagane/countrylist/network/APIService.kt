package com.matsyodree.atozpay.network

import com.pudagane.countrylist.model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface APIService {
    @GET("all")
    fun getAllCountriesList(): Call<List<Country>>

    @GET("region/{region}")
    fun getAllCountriesFromRegion(@Path("region") region: String): Call<List<Country>>

}