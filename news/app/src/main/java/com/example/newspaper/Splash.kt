package com.example.newspaper

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Splash: AppCompatActivity() {

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        handler = Handler()
        handler.postDelayed( {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }, 2000)
    }
}