package com.artemiod.pokeapi.domain

import com.artemiod.pokeapi.data.PokeRepository
import com.artemiod.pokeapi.domain.model.PokeItemDetails

class GetDetails {

    private val repository = PokeRepository()

    suspend fun fromPokemon(id: Int): PokeItemDetails? {
        return repository.getPokeDetails(id)
    }
}