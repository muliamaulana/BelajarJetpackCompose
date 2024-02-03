package com.muliamaulana.resepmasak.ui.common

/**
 * Created by muliamaulana on 04/02/24.
 */

sealed class UiState<out T: Any?> {

    object Loading : UiState<Nothing>()

    data class Success<out T: Any>(val data: T) : UiState<T>()

    data class Error(val errorMessage: String) : UiState<Nothing>()
}