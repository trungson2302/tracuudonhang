package com.sonpham.tracuudonhang.apis

import retrofit2.Retrofit

interface BaseShipmentAPI {
    val builder: Retrofit
        get() = Retrofit.Builder().baseUrl(getBaseUrl()).build()

    fun getBaseUrl(): String
}