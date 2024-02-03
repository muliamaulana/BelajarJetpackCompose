package com.muliamaulana.resepmasak.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muliamaulana.resepmasak.data.RecipeRepository
import com.muliamaulana.resepmasak.model.Recipe
import com.muliamaulana.resepmasak.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

/**
 * Created by muliamaulana on 04/02/24.
 */

class HomeViewModel(private val repository: RecipeRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<MutableList<Recipe>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<MutableList<Recipe>>> get() = _uiState

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun getRecipes(query: String) = viewModelScope.launch {
        _query.value = query

        if (_query.value.isEmpty()) {
            repository.getRecipes().catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collect { recipes ->
                _uiState.value = UiState.Success(recipes)
            }
            return@launch
        }

        repository.searchRecipe(_query.value).catch {
            _uiState.value = UiState.Error(it.message.toString())
        }.collect { recipes ->
            _uiState.value = UiState.Success(recipes)
        }
    }
}