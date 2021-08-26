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
import java.net.URL

class Weather: AppCompatActivity() {
    var url = "https://weather.naver.com/"
    var wea_fir = ""
    var wea_sec = ""
    var wea_thi = ""
    var wea_for = ""
    var wea_fiv = ""
    var wea_six = ""
    var wea_sev = ""
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
    }

    private fun set_image() {

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
                    0 -> { url = "https://weather.naver.com/"}
                    1 -> { url = "https://weather.naver.com/today/09140550" }
                    2 -> { url = "https://weather.naver.com/today/01810350" }
                    3 -> { url = "https://weather.naver.com/today/16760370" }
                    4 -> { url = "https://weather.naver.com/today/15810320" }
                    5 -> { url = "https://weather.naver.com/today/13750360" }
                    6 -> { url = "https://weather.naver.com/today/12830250" }
                    7 -> { url = "https://weather.naver.com/today/04170400" }
                    8 -> { url = "https://weather.naver.com/today/08470690" }
                    9 -> { url = "https://weather.naver.com/today/14110630" }
                    else -> { }
                }
                weather()
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
            val doc2 = Jsoup.connect("https://www.google.com/search?q=%EB%82%A0%EC%94%A8&oq=%EB%82%A0%EC%94%A8&aqs=chrome.0.69i59j0i131i433i512l2j0i433i512j0i512j0i433i512j0i3j0i512l2.1668j1j15&sourceid=chrome&ie=UTF-8").get()
            wea_fir = doc2.select("img.uW5pk")[0].attr("src")
            wea_sec = doc2.select("img.uW5pk")[1].attr("src")
            wea_thi = doc2.select("img.uW5pk")[2].attr("src")
            wea_for = doc2.select("img.uW5pk")[3].attr("src")
            wea_fiv = doc2.select("img.uW5pk")[4].attr("src")
            wea_six = doc2.select("img.uW5pk")[5].attr("src")
            wea_sev = doc2.select("img.uW5pk")[6].attr("src")
        }
        Glide.with(this).load("https:" + wea_fir)
                .into(findViewById(R.id.mon_weather))
        Glide.with(this).load("https:" + wea_sec)
                .into(findViewById(R.id.tue_weather))
        Glide.with(this).load("https:" + wea_thi)
                .into(findViewById(R.id.wed_weather))
        Glide.with(this).load("https:" + wea_for)
                .into(findViewById(R.id.thu_weather))
        Glide.with(this).load("https:" + wea_fiv)
                .into(findViewById(R.id.fri_weather))
        Glide.with(this).load("https:" + wea_six)
                .into(findViewById(R.id.sat_weather))
        Glide.with(this).load("https:" + wea_sev)
                .into(findViewById(R.id.sun_weather))
    }
}