package com.example.mvi_daggerhilt_demo.dependecy_Injection

import com.example.mvi_daggerhilt_demo.repository.MainRepository
import com.example.mvi_daggerhilt_demo.retrofit.BlogRetrofit
import com.example.mvi_daggerhilt_demo.retrofit.NetWorkMapper
import com.example.mvi_daggerhilt_demo.room.BlogDao
import com.example.mvi_daggerhilt_demo.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
            blogDao: BlogDao,
            retrofit: BlogRetrofit,
            cacheMapper: CacheMapper,
            networkMapper: NetWorkMapper
    ): MainRepository{
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}