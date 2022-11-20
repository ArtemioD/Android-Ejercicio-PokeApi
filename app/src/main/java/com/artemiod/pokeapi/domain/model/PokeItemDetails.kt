package com.artemiod.pokeapi.domain.model

import com.artemiod.pokeapi.data.model.PokeModelDetails
import com.artemiod.pokeapi.data.model.Types
import java.util.*

data class PokeItemDetails(
    val id: String,
    val name: String,
    val img: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense:Int,
    val speed: Int,
    val types: List<String>,
    val weight: Double,
    val height: Double
)

fun PokeModelDetails.toDomain(): PokeItemDetails {
    val id = "N° ${id.toString().padStart(3,'0')}"
    val name = replaceFirstChar(name)
    val img = sprites.other.officialArtwork.img
    val hp = pokemonDetails[0].statValue
    val attack = pokemonDetails[1].statValue
    val defense = pokemonDetails[2].statValue
    val specialAttack = pokemonDetails[3].statValue
    val specialDefense = pokemonDetails[4].statValue
    val speed = pokemonDetails[5].statValue
    val types = getTypes(types)
    val weight = weight / 10.0
    val height = height / 10.0
    return PokeItemDetails(id, name, img, hp, attack, defense,
        specialAttack, specialDefense, speed, types, weight, height)
}

private fun getTypes(types: List<Types>): List<String> {
    return if (types.size > 1) {
        listOf(replaceFirstChar(types[0].type.name), replaceFirstChar(types[1].type.name))
    } else {
        listOf(replaceFirstChar(types[0].type.name))
    }
}

private fun replaceFirstChar(t: String): String {
    return t.replaceFirstChar {
        // cada nombre con Mayuscula
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
}