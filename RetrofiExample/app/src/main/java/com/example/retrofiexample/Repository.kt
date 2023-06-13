package com.example.retrofiexample

import com.example.retrofiexample.network.ApiService

class Repository (private val apiService: ApiService){

    fun getCharacters(page:String)= apiService.fetchCharacter(page)
}