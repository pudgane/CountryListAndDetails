package com.matsyodree.atozpay.network

object ApiUtils {
    val BASE_URL = "http://restcountries.eu/rest/v2/"

    val apiService: APIService
        get() = RetrofitClient.getClient(BASE_URL)!!.create(APIService::class.java)

}