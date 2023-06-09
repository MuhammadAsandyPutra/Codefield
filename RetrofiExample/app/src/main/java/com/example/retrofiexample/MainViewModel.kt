package com.example.retrofiexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofiexample.network.ApiClient
import com.example.retrofiexample.network.Character
import com.example.retrofiexample.network.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel (private val repository: Repository = Repository(ApiClient.apiService)): ViewModel(){

    private var _characterLiveData = MutableLiveData<ScreenState<List<Character>?>>()
    val characterLiveData:LiveData<ScreenState<List<Character>?>>
        get() = _characterLiveData


    init {
        fetchCharacter()
    }
    private fun fetchCharacter(){
       val client = repository.getCharacters("1")
        _characterLiveData.postValue(ScreenState.Loading(null))
        client.enqueue(object : Callback<CharacterResponse>{
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful){
                    _characterLiveData.postValue(ScreenState.Success(response.body()?.result))
                }else{
                    _characterLiveData.postValue(ScreenState.Error(response.code().toString(),null))
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                //Log.d("Gagal",t.message.toString())
                _characterLiveData.postValue(ScreenState.Error(t.message.toString(),null))
            }
        })
    }
}