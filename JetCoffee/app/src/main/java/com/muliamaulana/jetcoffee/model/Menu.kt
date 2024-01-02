package com.muliamaulana.jetcoffee.model

import com.muliamaulana.jetcoffee.R

/**
 * Created by muliamaulana on 28/12/23.
 */
data class Menu(
    val image: Int,
    val title: String,
    val price: String,
)

val dummyMenu = listOf(
    Menu(R.drawable.menu1, "Tiramisu Coffee Milk", "Rp 28.000"),
    Menu(R.drawable.menu2, "Pumpkin Spice Latte", "Rp 18.000"),
    Menu(R.drawable.menu3, "Light Cappuccino", "Rp 20.000"),
    Menu(R.drawable.menu4, "Choco Creamy Latte", "Rp 16.000"),
)

val dummyBestSellerMenu = dummyMenu.shuffled()