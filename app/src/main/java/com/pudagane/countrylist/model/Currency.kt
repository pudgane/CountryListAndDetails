package com.pudagane.countrylist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Currency (

    @SerializedName("code")
    @Expose
    var code: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("symbol")
    @Expose
    var symbol: String? = null

): Serializable