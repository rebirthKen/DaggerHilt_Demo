package com.example.mvi_daggerhilt_demo.repository

import com.example.mvi_daggerhilt_demo.model.Blog
import com.example.mvi_daggerhilt_demo.retrofit.BlogRetrofit
import com.example.mvi_daggerhilt_demo.retrofit.NetWorkMapper
import com.example.mvi_daggerhilt_demo.room.BlogDao
import com.example.mvi_daggerhilt_demo.room.CacheMapper
import com.example.mvi_daggerhilt_demo.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val netWorkMapper: NetWorkMapper
) {
    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        // fake async delay
        delay(5000)

        try {
            val networkBlogs = blogRetrofit.get()
            val blogs = netWorkMapper.mapFromEntityList(networkBlogs)

            for (blog in blogs) {
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }

            val cachedBlogs = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}