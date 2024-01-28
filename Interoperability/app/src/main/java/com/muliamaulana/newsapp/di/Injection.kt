package com.muliamaulana.newsapp.di

import android.content.Context
import com.muliamaulana.newsapp.data.NewsRepository
import com.muliamaulana.newsapp.data.local.room.NewsDatabase
import com.muliamaulana.newsapp.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        return NewsRepository.getInstance(apiService, dao)
    }
}