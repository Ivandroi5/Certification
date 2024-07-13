package com.example.trialcertificaation.data.remote.network

/**
 * Lista de ciudades traido por la api.
 * @property id Identificador único de la ciudad.
 * @property ciudad Nombre de la ciudad.
 * @property region Nombre de la region.
 * @property viento boleano de viento
 * @property amanecer hora del amanecer.
 * @property atardecer hora del atardecer.
 * @property imagen url de la imagen.
 * @property temperatura temperatura.
 * @property detalles_tiempo Detalles del tiempo.

 */
data class NetworkList(
    val id: Int,
    val ciudad: String,
    val region: String,
    val imagen: String,
    val temperatura: String,
    val viento: Boolean,
    val amanecer: String,
    val atardecer: String,
    val detalles_tiempo: DetailTimeVar
)
