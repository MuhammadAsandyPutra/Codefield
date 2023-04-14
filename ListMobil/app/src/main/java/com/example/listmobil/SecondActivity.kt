package com.example.listmobil

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val secondHeading : TextView = findViewById(R.id.second_heading)
        val mainSecond : TextView = findViewById(R.id.second_detail)
        val imageSecond : ImageView = findViewById(R.id.second_image)

        val bundle : Bundle?= intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageId")
        val Cars = bundle.getString("Cars")



        secondHeading.text = heading
        mainSecond.text = Cars
        imageSecond.setImageResource(imageId)

    }
}