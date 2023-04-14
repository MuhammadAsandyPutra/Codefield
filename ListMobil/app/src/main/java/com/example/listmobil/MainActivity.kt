package com.example.listmobil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<cars>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var subheading : Array<String>
    lateinit var detail : Array<String>
    lateinit var Cars : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o
       )
        heading = arrayOf(
            "Aston Martin",
            "Audi",
            "Bentley",
            "BMW",
            "Bugatti",
            "Cadillac",
            "Hyundai",
            "Lamborghini",
            "Mazda",
            "Mercedes-Benz",
            "Mitsubishi",
            "Nissan",
            "Porsche",
            "Toyota",
            "Volvo"

        )
        subheading = arrayOf(
            getString(R.string.tahun_a),
            getString(R.string.tahun_b),
            getString(R.string.tahun_c),
            getString(R.string.tahun_d),
            getString(R.string.tahun_e),
            getString(R.string.tahun_f),
            getString(R.string.tahun_g),
            getString(R.string.tahun_h),
            getString(R.string.tahun_i),
            getString(R.string.tahun_j),
            getString(R.string.tahun_k),
            getString(R.string.tahun_l),
            getString(R.string.tahun_m),
            getString(R.string.tahun_n),
            getString(R.string.tahun_o),

        )
        detail = arrayOf(
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !",
            "Klik untuk melihat Detail !"
        )

        Cars = arrayOf(
            getString(R.string.detail_a),
            getString(R.string.detail_b),
            getString(R.string.detail_c),
            getString(R.string.detail_d),
            getString(R.string.detail_e),
            getString(R.string.detail_f),
            getString(R.string.detail_g),
            getString(R.string.detail_h),
            getString(R.string.detail_i),
            getString(R.string.detail_j),
            getString(R.string.detail_k),
            getString(R.string.detail_l),
            getString(R.string.detail_m),
            getString(R.string.detail_n),
            getString(R.string.detail_o),
        )


        newRecyclerView = findViewById(R.id.rv)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<cars>()
        getuserdata()

    }

    private fun getuserdata() {

        for (i in imageId.indices){

            val cars = cars(imageId[i],heading[i],subheading[i],detail[i])
            newArrayList.add(cars)

        }



        val adapter = CarsAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object :CarsAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                Toast.makeText( this@MainActivity, "You Clicked on item no. $position", Toast.LENGTH_SHORT).show()


                val intent = Intent(this@MainActivity,SecondActivity::class.java)
                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("imageId",newArrayList[position].titleImage)
                intent.putExtra("Cars",Cars[position])
                startActivity(intent)

            }


        })
    }

}