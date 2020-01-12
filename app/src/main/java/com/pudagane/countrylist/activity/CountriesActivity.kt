package com.pudagane.countrylist.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matsyodree.atozpay.network.APIService
import com.matsyodree.atozpay.network.ApiUtils
import com.pudagane.countrylist.BaseActivity
import com.pudagane.countrylist.R
import com.pudagane.countrylist.adapters.CountriesAdapter
import com.pudagane.countrylist.interfaces.OnItemClickListener
import com.pudagane.countrylist.model.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesActivity :  BaseActivity(), OnItemClickListener {


    private var tAG = CountriesActivity::class.java.getName()


    lateinit var countriesList :  ArrayList<Country>
    lateinit var countryRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

       val regionName = intent.getStringExtra("REGION")

        Log.d(tAG,"elemregionNameent=="+regionName)

        countryRV = findViewById(R.id.countries_recycler_view)
        countryRV?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        getAllCountriesListFromNet(regionName)


    }

    override fun onStart() {
        super.onStart()
    }

    private fun getAllCountriesListFromNet(regionName:String) {
        //Variable declaration
        var mAPIService: APIService? = null
        //After oncreate
        mAPIService = ApiUtils.apiService
        showProgressBar()

        mAPIService.getAllCountriesFromRegion(regionName).enqueue(object :  Callback<List<Country>> {

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                Log.d(tAG, StringBuilder().append("getAllCountriesFromRegion:onResponse:-").append(response.message()).append(response.code()).append(response.isSuccessful).toString())

                hideProgressBar()
                if (response.isSuccessful) {
                    countriesList= response.body() as ArrayList<Country>

                    Log.d(tAG,"countriesList size="+countriesList.size)

                   setAdapter()

                } else if (response.code() == 404) {
                    Log.d(tAG,"404 not found")
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.d(tAG, StringBuilder().append("getAllCountriesFromRegion:onFailure:-").append(t.message).toString())

                t.printStackTrace()
                Log.e(tAG, t.message!!)
                hideProgressBar()
                showToast(t.message!!)
            }
        })
    }

    private fun setAdapter() {
        val mAdapter = CountriesAdapter( countriesList, this,this)
        countryRV.adapter=mAdapter
    }

    override fun onItemClickPosition(i: Int) {
        val i1 = Intent(this, CountryDetailsActivity::class.java)
        i1.putExtra("COUNTRY", countriesList.get(i))
        startActivity(i1)
    }
}
