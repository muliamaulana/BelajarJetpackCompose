package com.muliamaulana.newsapp.ui.list

import androidx.lifecycle.ViewModel
import com.muliamaulana.newsapp.data.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getHeadlineNews() = newsRepository.getHeadlineNews()

    fun getBookmarkedNews() = newsRepository.getBookmarkedNews()
}