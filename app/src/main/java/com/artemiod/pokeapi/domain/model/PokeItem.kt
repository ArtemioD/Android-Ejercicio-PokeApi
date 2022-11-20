package com.artemiod.pokeapi.domain.model

import com.artemiod.pokeapi.data.model.PokeModel
import java.util.*

data class PokeItem(
    val id: Int,
    val name: String,
    val img: String
){
    val formatId = "N° ${id.toString().padStart(3,'0')}"
}

private const val URL_RAW = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

fun PokeModel.toDomain(): PokeItem {
    val arrayUrl = url.split("/")
    val id = arrayUrl[arrayUrl.size - 2].toInt()
    val name = name.replaceFirstChar {
        // cada nombre con Mayuscula
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
    val img = "$URL_RAW$id.png"
    return PokeItem(id, name, img)
}