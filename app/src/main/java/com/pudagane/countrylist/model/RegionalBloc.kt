package com.pudagane.countrylist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class RegionalBloc (

    @SerializedName("acronym")
    @Expose
    var acronym: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("otherAcronyms")
    @Expose
    var otherAcronyms: List<Any>? = null,
    @SerializedName("otherNames")
    @Expose
    var otherNames: List<Any>? = null

) : Serializable