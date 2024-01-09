package com.muliamaulana.jetheroes.data

import com.muliamaulana.jetheroes.model.Hero
import com.muliamaulana.jetheroes.model.HeroesData

/**
 * Created by muliamaulana on 08/01/24.
 */

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }

    fun searchHeroes(query: String): List<Hero> {
        return HeroesData.heroes.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}