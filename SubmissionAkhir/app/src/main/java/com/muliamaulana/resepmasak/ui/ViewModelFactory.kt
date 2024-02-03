package com.muliamaulana.resepmasak.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muliamaulana.resepmasak.data.RecipeRepository
import com.muliamaulana.resepmasak.ui.screen.home.HomeViewModel

/**
 * Created by muliamaulana on 04/02/24.
 */

class ViewModelFactory(private val repository: RecipeRepository):
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }

        throw IllegalArgumentException("Unkown ViewModel Class: "+modelClass.name)
    }
}