package com.muliamaulana.jetrewards.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muliamaulana.jetrewards.data.RewardRepository
import com.muliamaulana.jetrewards.ui.screen.cart.CartViewModel
import com.muliamaulana.jetrewards.ui.screen.detail.DetailRewardViewModel
import com.muliamaulana.jetrewards.ui.screen.home.HomeViewModel

/**
 * Created by muliamaulana on 19/01/24.
 */

class ViewModelFactory(private val repository: RewardRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailRewardViewModel::class.java)) {
            return DetailRewardViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}