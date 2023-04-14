package com.example.listmobil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class CarsAdapter(private val carLists : ArrayList<cars>) :
    RecyclerView.Adapter<CarsAdapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView=LayoutInflater.from(parent.context).inflate((R.layout.list_item),parent,false)
        return MyViewHolder(itemView,mListener)}

    override fun getItemCount(): Int {

        return carLists.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = carLists[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.heading.text = currentItem.heading
        holder.subheading.text = currentItem.subheading
        holder.detail.text = currentItem.detail


    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){


        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val heading : TextView = itemView.findViewById(R.id.heading)
        val subheading : TextView = itemView.findViewById(R.id.subheading)
        val detail : TextView = itemView.findViewById(R.id.detail)



        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }
    }
}