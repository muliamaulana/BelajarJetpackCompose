package com.muliamaulana.jetrewards.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muliamaulana.jetrewards.data.RewardRepository
import com.muliamaulana.jetrewards.model.OrderReward
import com.muliamaulana.jetrewards.model.Reward
import com.muliamaulana.jetrewards.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Created by muliamaulana on 19/01/24.
 */

class DetailRewardViewModel(
    private val repository: RewardRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderReward>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderReward>>
        get() = _uiState

    fun getRewardById(rewardId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderRewardById(rewardId))
        }
    }

    fun addToCart(reward: Reward, count: Int) {
        viewModelScope.launch {
            repository.updateOrderReward(reward.id, count)
        }
    }
}