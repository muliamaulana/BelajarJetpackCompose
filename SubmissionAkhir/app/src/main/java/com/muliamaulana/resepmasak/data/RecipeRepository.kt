package com.muliamaulana.resepmasak.data

import com.muliamaulana.resepmasak.model.FakeRecipeRepository
import com.muliamaulana.resepmasak.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * Created by muliamaulana on 29/01/24.
 */

class RecipeRepository {

    fun getRecipes() : Flow<MutableList<Recipe>> {
        return flowOf(FakeRecipeRepository.dummyRecipes)
    }

    fun searchRecipe(query: String?): Flow<MutableList<Recipe>> {
        return flowOf(
            FakeRecipeRepository.dummyRecipes.filter {
                query?.let { search -> it.title?.contains(search, ignoreCase = true) } == true
            }.toMutableList()
        )
    }
}