package com.example.trialcertificaation.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.trialcertificaation.data.local.Dao
import com.example.trialcertificaation.data.local.entities.LocalDetail
import com.example.trialcertificaation.data.local.entities.LocalList

/**
 * La base de datos de Room para almacenar la información del clima.
 */
@Database(
    entities = [LocalList::class, LocalDetail::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {

    //Obtiene el DAO para acceder a las operaciones de base de datos
    abstract fun getWheaterDao(): Dao


    //Obtiene la instancia de la base de datos.
    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDataBase(context: Context): DataBase {
            val temInstance = INSTANCE
            if (temInstance != null) {
                return temInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "Clima_bd"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}