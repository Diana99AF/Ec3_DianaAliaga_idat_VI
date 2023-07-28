package com.diana.ec3simpsons.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl("https://apisimpsons.fly.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val simpsonsInstance = retrofitInstance.create(SimpsonsInterface::class.java)
}