package com.pudagane.countrylist.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matsyodree.atozpay.network.APIService
import com.matsyodree.atozpay.network.ApiUtils
import com.pudagane.countrylist.BaseActivity
import com.pudagane.countrylist.R
import com.pudagane.countrylist.adapters.RegionAdapter
import com.pudagane.countrylist.model.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : BaseActivity() {
    private var tAG = MainActivity::class.java.getName()

   lateinit var continents :  Array<String>
    lateinit var my_recycler_view :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         my_recycler_view = findViewById(R.id.continents_recycler_view)
        getAllCountriesListFromNet()

    }

    private fun setAdapter() {
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.setHasFixedSize(true)
        my_recycler_view.adapter =
            RegionAdapter(continents, { continent -> continentItemClicked(continent) })
    }

    private fun continentItemClicked(continent: String) {
        val i1 = Intent(this, CountriesActivity::class.java)
        i1.putExtra("REGION", continent)
        startActivity(i1)
    }


    private fun getAllCountriesListFromNet() {
        //Variable declaration
        var mAPIService: APIService? = null
        //After oncreate
        mAPIService = ApiUtils.apiService
        showProgressBar()

        mAPIService.getAllCountriesList().enqueue(object : Callback<List<Country>> {

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                Log.d(tAG, StringBuilder().append("getAllCountriesListFromNet:onResponse:-").append(response.message()).append(response.code()).append(response.isSuccessful).toString())

                hideProgressBar()
                if (response.isSuccessful) {
                  val allContries= response.body() as List<Country>
                    val set = HashSet<String>(10)
                    for (element in allContries){
                        if(element.region!!.length>0)
                        set.add(element.region!!)
                    }
                    continents = set.toTypedArray()
                    for (element in continents){
                        Log.d(tAG,"element=="+element)
                    }
                    setAdapter()

                } else if (response.code() == 404) {
                    Log.d(tAG,"404 not found")
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.d(tAG, StringBuilder().append("getAllCountriesListFromNet:onFailure:-").append(t.message).toString())

                t.printStackTrace()
                Log.e(tAG, t.message!!)
                hideProgressBar()
                showToast(t.message!!)
            }
        })
    }
}
