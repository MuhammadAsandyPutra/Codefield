package com.example.retrofiexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofiexample.network.Character

class MainAdapter(val characterList: List<Character>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(private val itemview : View):RecyclerView.ViewHolder(itemview){
        fun bindData(character: Character){
            val name = itemView.findViewById<TextView>(R.id.name)
            val image = itemView.findViewById<ImageView>(R.id.image)
            val rangkuman = itemView.findViewById<TextView>(R.id.rangkuman)

            name.text = character.name
            rangkuman.text = character.rangkuman
            Glide.with(itemView)
                .load(character.image)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false))
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(characterList[position])
    }
}
