package com.artemiod.pokeapi.data

import com.artemiod.pokeapi.data.network.ApiService
import com.artemiod.pokeapi.domain.model.PokeItem
import com.artemiod.pokeapi.domain.model.PokeItemDetails
import com.artemiod.pokeapi.domain.model.toDomain

class PokeRepository {

    private val api = ApiService()

    suspend fun getAllPokemons(): List<PokeItem> {
        val response = api.getPokemons()
        return response.map { it.toDomain() }
    }

    suspend fun getPokeDetails(id: Int): PokeItemDetails? {
        val response = api.getDetailsPokemon(id)
        return response?.toDomain()
    }
}