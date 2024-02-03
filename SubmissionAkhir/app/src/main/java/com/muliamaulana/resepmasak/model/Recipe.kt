package com.muliamaulana.resepmasak.model

/**
 * Created by muliamaulana on 29/01/24.
 */
data class Recipe(
    val id: String = "",
    val title: String? = null,
    val times: String? = null,
    val difficulty: String? = null,
    val servings: String? = null,
    val ingredient: MutableList<String>? = null,
    val step: MutableList<String>? = null,
    val thumbnail: String? = null,
)
