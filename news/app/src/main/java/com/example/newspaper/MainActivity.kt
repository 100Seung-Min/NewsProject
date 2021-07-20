package com.example.newspaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2=findViewById<ViewPager2>(R.id.viewpager)

        val adapter=Adapter(supportFragmentManager, lifecycle)

        viewPager2.adapter=adapter

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