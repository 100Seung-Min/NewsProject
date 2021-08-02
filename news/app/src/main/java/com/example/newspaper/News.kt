package com.example.newspaper

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class News: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news)

        var i = 0

        val image = findViewById<ImageView>(R.id.img)
        image.setOnClickListener {
            if(i == 1) {
                image.setImageResource(R.drawable.nature)
                i = 0;
            }
            else {
                image.setImageResource(R.drawable.ic_launcher_foreground)
                i = 1;
            }
        }


        val home = findViewById<ImageView>(R.id.home)
        home.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }

        val news = findViewById<ImageView>(R.id.news)
        news.setOnClickListener(){
            val intent = Intent(this, News::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }

        val weather = findViewById<ImageView>(R.id.weather)
        weather.setOnClickListener(){
            val intent = Intent(this, Weather::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }
    }
}