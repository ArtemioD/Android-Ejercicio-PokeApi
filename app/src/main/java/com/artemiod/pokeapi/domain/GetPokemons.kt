package com.artemiod.pokeapi.domain

import com.artemiod.pokeapi.data.PokeRepository
import com.artemiod.pokeapi.domain.model.PokeItem

class GetPokemons {

    private val repository = PokeRepository()

    suspend fun listAll(): List<PokeItem> {
        return repository.getAllPokemons()
    }
}