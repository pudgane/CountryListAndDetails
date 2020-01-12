package com.pudagane.countrylist.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.pudagane.countrylist.R
import com.pudagane.countrylist.model.Country

class CountryDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        val countryObj: Country = intent.getSerializableExtra("COUNTRY") as Country
        Log.d("CountryDetailsActivity",countryObj.toString())

        val image = findViewById<ImageView>(R.id.c_image)
        GlideToVectorYou.justLoadImage(this, Uri.parse( countryObj.flag), image)

        findViewById<TextView>(R.id.country_name).setText(countryObj.name)
        findViewById<TextView>(R.id.capital_name).setText(countryObj.capital)
        findViewById<TextView>(R.id.region_name).setText(countryObj.region)
        findViewById<TextView>(R.id.population).setText(countryObj.population.toString())






    }
}
