package com.example.retrofiexample.network

import com.squareup.moshi.Json

 data class Character (
     @Json(name = "title")
     val name: String,
     @Json(name = "image_url")
     val image: String,
     @Json (name = "summary")
     val rangkuman: String
         )
data class CharacterResponse(@Json(name="results")
val result : List<Character>)