package com.example.trialcertificaation.data.remote.network

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class DetailNetworkTest {

    @Test
    fun `test initialization and access`() {
        val detallesTiempo = DetailTimeVar(pronostico = "Nublado", siguientedia = "Lluvioso")
        val detailNetwork = DetailNetwork(
            id = 1,
            ciudad = "Santiago",
            region = "Metropolitana",
            imagen = "https://example.com/image.jpg",
            temperatura = "20", // Asumiendo que temperatura es un String según la data class original
            viento = true,
            amanecer = "6:00 am",
            atardecer = "6:00 pm",
            detalles_tiempo = detallesTiempo
        )

        assertEquals(1, detailNetwork.id)
        assertEquals("Santiago", detailNetwork.ciudad)
        assertEquals("Metropolitana", detailNetwork.region)
        assertEquals("https://example.com/image.jpg", detailNetwork.imagen)
        assertEquals("20", detailNetwork.temperatura) // Asegúrate de que coincida con el tipo de dato esperado
        assertEquals(true, detailNetwork.viento)
        assertEquals("6:00 am", detailNetwork.amanecer)
        assertEquals("6:00 pm", detailNetwork.atardecer)
        assertEquals(detallesTiempo, detailNetwork.detalles_tiempo)
    }
    @Test
    fun `test toString`() {
        val detallesTiempo = DetailTimeVar(pronostico = "Nublado", siguientedia = "Lluvioso")
        val detailNetwork = DetailNetwork(
            id = 1,
            ciudad = "Santiago",
            region = "Metropolitana",
            imagen = "https://example.com/image.jpg",
            temperatura = "20",
            viento = true,
            amanecer = "6:00 am",
            atardecer = "6:00 pm",
            detalles_tiempo = detallesTiempo
        )

        val expectedString = "DetailNetwork(id=1, ciudad=Santiago, region=Metropolitana, imagen=https://example.com/image.jpg, temperatura=20, viento=true, amanecer=6:00 am, atardecer=6:00 pm, detalles_tiempo=$detallesTiempo)"
        assertEquals(expectedString, detailNetwork.toString())
    }

    @Test
    fun `test equals`() {
        val detallesTiempo1 = DetailTimeVar(pronostico = "Nublado", siguientedia = "Lluvioso")
        val detallesTiempo2 = DetailTimeVar(pronostico = "Despejado", siguientedia = "Soleado")
        val detailNetwork1 = DetailNetwork(
            id = 1,
            ciudad = "Santiago",
            region = "Metropolitana",
            imagen = "https://example.com/image.jpg",
            temperatura = "20",
            viento = true,
            amanecer = "6:00 am",
            atardecer = "6:00 pm",
            detalles_tiempo = detallesTiempo1
        )
        val detailNetwork2 = DetailNetwork(
            id = 1,
            ciudad = "Santiago",
            region = "Metropolitana",
            imagen = "https://example.com/image.jpg",
            temperatura = "20",
            viento = true,
            amanecer = "6:00 am",
            atardecer = "6:00 pm",
            detalles_tiempo = detallesTiempo2
        )

        assertEquals(detailNetwork1, detailNetwork2)
    }

    @Test
    fun `test hashCode`() {
        val detallesTiempo = DetailTimeVar(pronostico = "Nublado", siguientedia = "Lluvioso")
        val detailNetwork1 = DetailNetwork(
            id = 1,
            ciudad = "Santiago",
            region = "Metropolitana",
            imagen = "https://example.com/image.jpg",
            temperatura = "20",
            viento = true,
            amanecer = "6:00 am",
            atardecer = "6:00 pm",
            detalles_tiempo = detallesTiempo
        )
        val detailNetwork2 = DetailNetwork(
            id = 1,
            ciudad = "Santiago",
            region = "Metropolitana",
            imagen = "https://example.com/image.jpg",
            temperatura = "20",
            viento = true,
            amanecer = "6:00 am",
            atardecer = "6:00 pm",
            detalles_tiempo = detallesTiempo
        )

        assertEquals(detailNetwork1.hashCode(), detailNetwork2.hashCode())

        // Asegúrate de que objetos distintos tengan hashCodes distintos
        val detailNetwork3 = DetailNetwork(
            id = 2,
            ciudad = "Valparaíso",
            region = "Valparaíso",
            imagen = "https://example.com/image2.jpg",
            temperatura = "25",
            viento = false,
            amanecer = "7:00 am",
            atardecer = "7:00 pm",
            detalles_tiempo = detallesTiempo
        )
        assertNotEquals(detailNetwork1.hashCode(), detailNetwork3.hashCode())
    }
}
