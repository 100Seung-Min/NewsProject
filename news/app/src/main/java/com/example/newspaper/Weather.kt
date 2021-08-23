package com.example.newspaper

import android.content.Intent
import android.icu.text.Transliterator
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.newspaper.databinding.WeatherBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk25.coroutines.onItemSelectedListener
import org.jsoup.Jsoup

class Weather: AppCompatActivity() {
    var url = "https://weather.naver.com/"
    var i = 1
    private var _biding: WeatherBinding? = null
    private val binding get() = _biding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _biding = WeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup_location()
        chose_location()

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

//        val loc = findViewById<ImageButton>(R.id.btn_loc)
//        loc.setOnClickListener(){
//            var intent = Intent(this, MapsActivity::class.java)
//            startActivity(intent)
//        }

        Glide.with(this).load("https://ssl.gstatic.com/onebox/weather/64/partly_cloudy.png")
                .into(findViewById(R.id.mon_weather))
        Glide.with(this).load("https://ssl.gstatic.com/onebox/weather/64/partly_cloudy.png")
                .into(findViewById(R.id.tue_weather))
        Glide.with(this).load("https://ssl.gstatic.com/onebox/weather/64/partly_cloudy.png")
                .into(findViewById(R.id.wed_weather))
        Glide.with(this).load("https://ssl.gstatic.com/onebox/weather/64/partly_cloudy.png")
                .into(findViewById(R.id.thu_weather))
        Glide.with(this).load("https://ssl.gstatic.com/onebox/weather/64/partly_cloudy.png")
                .into(findViewById(R.id.fri_weather))
        Glide.with(this).load("https://ssl.gstatic.com/onebox/weather/64/partly_cloudy.png")
                .into(findViewById(R.id.sat_weather))
        Glide.with(this).load("https://ssl.gstatic.com/onebox/weather/64/partly_cloudy.png")
                .into(findViewById(R.id.sun_weather))
    }
    private fun setup_location() {
        val location = resources.getStringArray(R.array.location)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, location)
        findViewById<Spinner>(R.id.btn_loc).adapter = adapter
    }
    private fun chose_location() {
        binding.btnLoc.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                weather()
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position) {
                    0 -> {
                        url = "https://weather.naver.com/"
                        weather()
                    }
                    1 -> {
                        url = "https://weather.naver.com/today/09140550"
                        weather()
                    }
                    2 -> {
                        url = "https://weather.naver.com/today/01810350"
                        weather()
                    }
                    3 -> {
                        url = "https://weather.naver.com/today/16760370"
                        weather()
                    }
                    4 -> {
                        url = "https://weather.naver.com/today/15810320"
                        weather()
                    }
                    5 -> {
                        url = "https://weather.naver.com/today/13750360"
                        weather()
                    }
                    6 -> {
                        url = "https://weather.naver.com/today/12830250"
                        weather()
                    }
                    7 -> {
                        url = "https://weather.naver.com/today/04170400"
                        weather()
                    }
                    8 -> {
                        url = "https://weather.naver.com/today/08470690"
                        weather()
                    }
                    9 -> {
                        url = "https://weather.naver.com/today/14110630"
                        weather()
                    }
                    else -> {
                        weather()
                    }
                }
            }
        }
    }
    private fun weather() {
        doAsync {
            val doc = Jsoup.connect(url). get()
            val temperature = doc.select("strong.current").text()
            val other = doc.select("dl.summary_list").text()
            val mise = doc.select("div.ttl_area").text()
            val print_t = findViewById<TextView>(R.id.temperate)
            val print_o = findViewById<TextView>(R.id.other)
            val print_m = findViewById<TextView>(R.id.wind)
            print_t.setText(temperature)
            print_o.setText(other)
            print_m.setText(mise)
        }
    }
}