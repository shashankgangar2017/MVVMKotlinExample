package com.example.mvvmkotlinexample.retrofit

import com.example.mvvmkotlinexample.model.ServicesSetterGetter
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("RetEmpDetails_1.aspx?mpin=8995&email=shashank@mobitrail.com&AppVersion=8.10")
    fun getServices() : Call<JsonElement>

}