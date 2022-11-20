package com.artemiod.pokeapi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemiod.pokeapi.domain.GetPokemons
import com.artemiod.pokeapi.domain.model.PokeItem
import kotlinx.coroutines.launch

enum class ApiStatus {LOADING, ERROR, DONE}

class PokeViewModel : ViewModel() {

    private var _pokemonList = MutableLiveData<List<PokeItem>>()
    val pokemonList: LiveData<List<PokeItem>>
            get() = _pokemonList

    private var _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
            get() = _status

    init {
        getAllPokemons()
    }

    fun getAllPokemons() {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                _pokemonList.value = GetPokemons().listAll()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                Log.d("tag", "${e.message}")
                _pokemonList.value = listOf()
            }
        }
    }
}