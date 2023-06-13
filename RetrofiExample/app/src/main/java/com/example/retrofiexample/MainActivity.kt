package com.example.retrofiexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retrofiexample.network.Character



class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.characterLiveData.observe(this,{state ->
            loadCharacterResponse(state)
        })

    }



    private fun loadCharacterResponse(state: ScreenState<List<Character>?>){
        when(state){
            is ScreenState.Loading -> {

            }
            is ScreenState.Success -> {

                if (state.data != null){
                    val adapter = MainAdapter(state.data)
                    val recyclerView = findViewById<RecyclerView>(R.id.charactersRv)
                    recyclerView?.layoutManager =
                        StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                    recyclerView?.adapter = adapter
                }

            }
            is ScreenState.Error ->{

            }


        }
    }
}
