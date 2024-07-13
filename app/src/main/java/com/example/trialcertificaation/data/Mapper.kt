package com.example.trialcertificaation.data

import com.example.trialcertificaation.data.local.entities.LocalDetail
import com.example.trialcertificaation.data.local.entities.LocalList
import com.example.trialcertificaation.data.remote.network.DetailNetwork
import com.example.trialcertificaation.data.remote.network.NetworkList

/**
 * Convierte una lista de climas de Internet a una lista de climas locales.
 *
 * @param weatherList La lista de climas de internet.
 * @property ciudad Nombre de la ciudad.
 * @property region Nombre de la region.
 * @property amanecer hora del amanecer.
 * @property atardecer hora del atardecer.
 * @property pronostico clima hoy.
 * @property siguientedia clima mañana.
 */
fun weatherNetwork(weatherList: List<NetworkList>): List<LocalList> {

    return weatherList.map {
        LocalList(
            id = it.id,
            ciudad = it.ciudad,
            region = it.region,
            imagen = it.imagen,
            temperatura = it.temperatura,
            viento = it.viento,
            amanecer = it.amanecer,
            atardecer = it.atardecer,
            pronostico = it.detalles_tiempo?.pronostico ?: "No disponible", // Acceso seguro a pronostico
            siguientedia = it.detalles_tiempo?.siguientedia ?: "No disponible"
        )
    }
}

/**
 *
 * @param detail Los detalles del clima de la ciudad traido de internet.
 * @return Los detalles del clima transforrmados
 */
fun detailNetWork(detail: DetailNetwork): LocalDetail {
    val pronostico = detail.detalles_tiempo?.pronostico ?: "No disponible"
    val siguientedia = detail.detalles_tiempo.siguientedia ?: "No disponible"
    return LocalDetail(
        id = detail.id,
        ciudad = detail.ciudad,
        region = detail.region,
        imagen = detail.imagen,
        temperatura = detail.temperatura,
        viento = detail.viento,
        amanecer = detail.amanecer,
        atardecer = detail.atardecer,
        pronostico = pronostico,
        siguientedia = siguientedia
    )
}