package com.muliamaulana.jetrewards.ui.screen.cart

import com.muliamaulana.jetrewards.model.OrderReward

/**
 * Created by muliamaulana on 19/01/24.
 */
data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)
