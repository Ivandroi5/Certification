package com.example.trialcertificaation.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.trialcertificaation.data.local.entities.LocalDetail
import com.example.trialcertificaation.data.local.entities.LocalList


/**
 * DAO (Data Access Object) para acceder a las entidades relacionadas en la base de datos.
 */
@Dao
interface Dao {

    //Insertar lista de conciertos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListWeather(listaClima: List<LocalList>)

    //Seleccionar listado de conciertos
    @Query("SELECT * FROM lista_clima_tabla ORDER BY id ASC")
    fun getListWeather(): LiveData<List<LocalList>>

    //Insertar detalle de concierto
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailWeather(weather: LocalDetail)

    //Seleccionar detalle
    @Query("SELECT * FROM detalle_tabla WHERE id= :id")
    fun getDetaikWheather(id: Int): LiveData<LocalDetail>
}