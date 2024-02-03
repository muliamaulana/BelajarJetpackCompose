package com.muliamaulana.resepmasak.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.muliamaulana.resepmasak.data.RecipeRepository
import com.muliamaulana.resepmasak.model.Recipe
import com.muliamaulana.resepmasak.ui.ViewModelFactory
import com.muliamaulana.resepmasak.ui.common.UiState
import com.muliamaulana.resepmasak.ui.components.RecipeItem
import com.muliamaulana.resepmasak.ui.components.RecipeSearchBar

/**
 * Created by muliamaulana on 30/01/24.
 */

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(RecipeRepository())
    ),
    navigationToDetail: (String?) -> Unit
) {

    viewModel.uiState.collectAsState().value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getRecipes(viewModel.query.value)
            }

            is UiState.Success -> {
                HomeContent(
                    recipes = uiState.data,
                    modifier = modifier,
                    viewModel = viewModel,
                    navigationToDetail = navigationToDetail
                )
            }

            is UiState.Error -> {}
        }
    }

}

@Composable
fun HomeContent(
    recipes: MutableList<Recipe>,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    navigationToDetail: (String?) -> Unit
) {

    Column(modifier = modifier) {

        RecipeSearchBar(
            query = viewModel.query.value,
            onQueryChange = viewModel::getRecipes,
            modifier = Modifier.background(MaterialTheme.colorScheme.primary)
        )

        LazyColumn() {
            items(recipes.toList(), key = { it.id }) {
                RecipeItem(
                    recipe = it,
                    modifier = Modifier.clickable {
                        navigationToDetail(it.id)
                    }
                )
            }
        }
    }
}