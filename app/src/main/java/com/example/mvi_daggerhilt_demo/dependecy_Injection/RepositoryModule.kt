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

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        blogRetrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        netWorkMapper: NetWorkMapper
    ) : MainRepository = MainRepository(blogDao, blogRetrofit, cacheMapper, netWorkMapper)
}