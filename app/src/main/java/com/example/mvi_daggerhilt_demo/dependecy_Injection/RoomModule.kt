package com.example.mvi_daggerhilt_demo.dependecy_Injection

import android.content.Context
import androidx.room.Room
import com.example.mvi_daggerhilt_demo.retrofit.BlogRetrofit
import com.example.mvi_daggerhilt_demo.room.BlogDao
import com.example.mvi_daggerhilt_demo.room.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent:: class)
object RoomModule {
    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): BlogDatabase = Room.databaseBuilder(context, BlogDatabase::class.java, BlogDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideDAO(blogDatabase: BlogDatabase): BlogDao = blogDatabase.blogDao()

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder): BlogRetrofit = retrofit.build().create(
        BlogRetrofit::class.java)
}