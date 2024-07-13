package com.example.trialcertificaation.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.trialcertificaation.data.local.Dao
import com.example.trialcertificaation.data.local.entities.LocalDetail
import com.example.trialcertificaation.data.local.entities.LocalList
import com.example.trialcertificaation.data.remote.Retrofit

/**
 * Repositorio para gestionar las operaciones relacionadas con el clima.
 *
 * @property dao DAO para acceder a la base de datos de conciertos.
 */
class Repository(private val dao: Dao) {

    //Retrofit
    private val networkService = Retrofit.getRetrofit()


    val listWeatherRepo = dao.getListWeather()


    val detailWeatherLocal = MutableLiveData<LocalDetail>()


    val listWeatherLocal = MutableLiveData<LocalList>()


    suspend fun fetchWeather() {
        val service = kotlin.runCatching { networkService.fetchWeatherList() }

        service.onSuccess {
            when (it.code()) {
                in 200..299 -> it.body()?.let {
                    Log.d("Clima", it.toString())
                    dao.insertListWeather(weatherNetwork(it))
                }

                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }

            service.onFailure {
                Log.d("Error", "${it.message}")
            }
        }
    }


    //Obtiene los detalles del clima de una ciudad específico por ID desde el servidor y los almacena en la base de datos.
    suspend fun fetchDetailWeather(id: Int): LocalDetail? {
        val service = kotlin.runCatching { networkService.fetchDetailWeather(id) }

        return service.getOrNull()?.body()?.let { concierto ->
            val detailWeatherEntity = detailNetWork(concierto)
            dao.insertDetailWeather(detailWeatherEntity)
            detailWeatherEntity

        }
    }


}