package com.example.trialcertificaation.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.trialcertificaation.data.Repository
import com.example.trialcertificaation.data.local.database.DataBase
import com.example.trialcertificaation.data.local.entities.LocalDetail
import com.example.trialcertificaation.data.local.entities.LocalList
import kotlinx.coroutines.launch

/**
 * ViewModel para manejar la lógica de la pantalla
 */
class ViewModel(aplicacion: Application) : AndroidViewModel(aplicacion) {

    //Conexion repositorio
    private val repo: Repository

    //Entidad
    private val detailWeatherLocal = MutableLiveData<LocalDetail>()

    init {
        val bd = DataBase.getDataBase(aplicacion)
        val weatherDao = bd.getWheaterDao()
        repo = Repository(weatherDao)

        //Llamar a fetchLista
        viewModelScope.launch {
            repo.fetchWeather()
        }
    }


    //Listado elementos
    fun getListWeather(): LiveData<List<LocalList>> = repo.listWeatherRepo

    //Detalle de ciudades
    fun getDetailWeather(): LiveData<LocalDetail> = detailWeatherLocal


    //Obtiene los detalles de desde la API y los guarda en el LiveData.
    fun getDetailNetwork(id: Int) = viewModelScope.launch {
        val detailWeather = repo.fetchDetailWeather(id)
        detailWeather?.let {
            detailWeatherLocal.postValue(it)
        }
    }


}