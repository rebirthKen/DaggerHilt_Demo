package com.example.mvi_daggerhilt_demo.dependecy_Injection

import com.example.mvi_daggerhilt_demo.retrofit.BlogRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/***
 * for Hilt it is very easy, we don't need to add these models to
 * components
 * we can just add a @InstallIn and tell it where we are going to be installing it
 */

const val BASE_URL = "https://open-api.xyz/placehlder/"
@Module
@InstallIn(ApplicationComponent:: class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson= GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()


    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))


    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder): BlogRetrofit= retrofit.build().create(BlogRetrofit::class.java)
}