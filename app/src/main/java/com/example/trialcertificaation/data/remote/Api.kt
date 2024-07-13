package com.example.trialcertificaation.data.remote

import com.example.trialcertificaation.data.remote.network.DetailNetwork
import com.example.trialcertificaation.data.remote.network.NetworkList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interfaz para las llamadas a la API.
 */
interface Api {

    //Obtiene la lista del servidor.
    @GET("data")
    suspend fun fetchWeatherList(): Response<List<NetworkList>>

    //Obtiene los detalles por ID desde el servidor.
    @GET("data/{id}")
    suspend fun fetchDetailWeather(@Path("id") id: Int): Response<DetailNetwork>
}