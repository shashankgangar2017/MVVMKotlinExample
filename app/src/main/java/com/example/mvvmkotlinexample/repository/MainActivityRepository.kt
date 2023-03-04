package com.example.mvvmkotlinexample.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmkotlinexample.model.ServicesSetterGetter
import com.example.mvvmkotlinexample.retrofit.RetrofitClient
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServicesApiCall(): MutableLiveData<ServicesSetterGetter> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object: Callback<JsonElement> {
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<JsonElement>,
                response: Response<JsonElement>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

//                val msg = data!!.message

                serviceSetterGetter.value = ServicesSetterGetter(response.body())
            }
        })

        return serviceSetterGetter
    }
}