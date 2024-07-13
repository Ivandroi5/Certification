package com.example.trialcertificaation.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Configurar retrofit
 */
class Retrofit {

    companion object{

        private const val BASE_URL = "https://tiempo-e38el7dv5-talento-projects.vercel.app/"

        //Instancia de Retrofit.
        lateinit var retrofitInstance: Retrofit

        //Obtiene la implementación de Api.
        fun getRetrofit(): Api {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(Api::class.java)
        }
    }
}