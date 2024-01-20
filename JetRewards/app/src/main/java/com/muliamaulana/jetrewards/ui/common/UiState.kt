package com.muliamaulana.jetrewards.ui.common

/**
 * Created by muliamaulana on 19/01/24.
 */

sealed class UiState<out T: Any?> {

    object Loading : UiState<Nothing>()

    data class Success<out T: Any>(val data: T) : UiState<T>()

    data class Error(val errorMessage: String) : UiState<Nothing>()
}