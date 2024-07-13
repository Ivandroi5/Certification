package com.example.trialcertificaation.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entidad local para almacenar lista de climas.
 *
 * @property id Identificador único de la ciudad.
 * @property ciudad Nombre de la ciudad.
 * @property region Nombre de la region.
 * @property viento boleano de viento
 * @property amanecer hora del amanecer.
 * @property atardecer hora del atardecer.
 * @property pronostico clima hoy.
 * @property siguientedia clima mañana
 * @property imagen imagen del clima
 * @property temperatura temperatura del clima
 */

@Entity(tableName = "detalle_tabla")
data class LocalDetail(
    @PrimaryKey
    val id: Int,
    val ciudad: String,
    val region: String,
    val imagen: String,
    val temperatura: String,
    val viento: Boolean,
    val amanecer: String,
    val atardecer: String,
    val pronostico: String,
    val siguientedia: String
)

