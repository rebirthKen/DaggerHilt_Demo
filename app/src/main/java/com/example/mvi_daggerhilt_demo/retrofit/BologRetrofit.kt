package com.example.mvi_daggerhilt_demo.retrofit

import retrofit2.http.GET

interface BologRetrofit {
    @GET(value = "blogs")
    suspend fun get(): List<BlogNetworkEntity>
}