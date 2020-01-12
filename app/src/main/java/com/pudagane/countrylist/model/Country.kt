package com.pudagane.countrylist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Country (

    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("topLevelDomain")
    @Expose
    var topLevelDomain: List<String>? = null,
    @SerializedName("alpha2Code")
    @Expose
    var alpha2Code: String? = null,
    @SerializedName("alpha3Code")
    @Expose
    var alpha3Code: String? = null,
    @SerializedName("callingCodes")
    @Expose
    var callingCodes: List<String>? = null,
    @SerializedName("capital")
    @Expose
    var capital: String? = null,
    @SerializedName("altSpellings")
    @Expose
    var altSpellings: List<String>? = null,
    @SerializedName("region")
    @Expose
    var region: String? = null,
    @SerializedName("subregion")
    @Expose
    var subregion: String? = null,
    @SerializedName("population")
    @Expose
    var population: Int? = null,
    @SerializedName("latlng")
    @Expose
    var latlng: List<Double>? = null,
    @SerializedName("demonym")
    @Expose
    var demonym: String? = null,
    @SerializedName("area")
    @Expose
    var area: Double? = null,
    @SerializedName("gini")
    @Expose
    var gini: Any? = null,
    @SerializedName("timezones")
    @Expose
    var timezones: List<String>? = null,
    @SerializedName("borders")
    @Expose
    var borders: List<String>? = null,
    @SerializedName("nativeName")
    @Expose
    var nativeName: String? = null,
    @SerializedName("numericCode")
    @Expose
    var numericCode: String? = null,
    @SerializedName("currencies")
    @Expose
    var currencies: List<Currency>? = null,
    @SerializedName("languages")
    @Expose
    var languages: List<Language>? = null,
    @SerializedName("translations")
    @Expose
    var translations: Translations? = null,
    @SerializedName("flag")
    @Expose
    var flag: String? = null,
    @SerializedName("regionalBlocs")
    @Expose
    var regionalBlocs: List<RegionalBloc>? = null,
    @SerializedName("cioc")
    @Expose
    var cioc: String? = null

) : Serializable