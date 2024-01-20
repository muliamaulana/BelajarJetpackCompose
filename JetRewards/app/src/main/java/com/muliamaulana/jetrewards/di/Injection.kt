package com.muliamaulana.jetrewards.di

import com.muliamaulana.jetrewards.data.RewardRepository

/**
 * Created by muliamaulana on 19/01/24.
 */

object Injection {
    fun provideRepository(): RewardRepository {
        return RewardRepository.getInstance()
    }
}