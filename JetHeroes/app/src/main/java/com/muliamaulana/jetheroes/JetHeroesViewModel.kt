package com.muliamaulana.jetheroes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muliamaulana.jetheroes.data.HeroRepository
import com.muliamaulana.jetheroes.model.Hero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


/**
 * Created by muliamaulana on 08/01/24.
 */

class JetHeroesViewModel(repository: HeroRepository) : ViewModel() {

    private val _groupedHeroes = MutableStateFlow(
        repository.getHeroes()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )

    val groupedHeroes: StateFlow<Map<Char, List<Hero>>> get() = _groupedHeroes
}

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val respository: HeroRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JetHeroesViewModel::class.java)) {
            return JetHeroesViewModel(respository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: "+modelClass.name)
    }
}