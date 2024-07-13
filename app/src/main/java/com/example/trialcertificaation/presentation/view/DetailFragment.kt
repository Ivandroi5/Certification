package com.example.trialcertificaation.presentation.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.trialcertificaation.data.remote.network.DetailNetwork
import com.example.trialcertificaation.presentation.viewmodel.ViewModel
import com.example.trialcertificaation.databinding.FragmentSecondBinding
import java.net.URLEncoder

/**
 * Segundo fragmento en la navegación, muestra los detalles de un concierto.
 */
class DetailFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModel by activityViewModels()
    private var idWeather: Int? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtener el ID seleccionado
        arguments?.let { bundle ->
            idWeather = bundle.getInt("idSelect")
            Log.d("Segundofrag", idWeather.toString())

        }


        idWeather?.let { id ->
            viewModel.getDetailNetwork(id)
        }

        viewModel.getDetailWeather().observe(viewLifecycleOwner, Observer {



            //Cargar datos
            Glide.with(binding.imgSegFragm).load(it.imagen).into(binding.imgSegFragm)
            binding.txtCity.text = it.ciudad
            binding.txtTemperature.text = "Temperatura: ${it.temperatura}"+"°C"
            binding.textWind.text = "Viento: ${if (it.viento) "Si" else "No"}"
            binding.txtForecast.text = "Hoy: ${it.pronostico}"
            binding.txtTomarrow.text = "Para mañana: ${it.siguientedia}"



            binding.wsoAction.setOnClickListener {
                //sendMessageWhatSApp()
            }


        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun sendMessageWhatSApp(detail: DetailNetwork){

        val telefonoWsp = "+56965914434"
        val mensaje = "Hola , la temperatura para ${detail.ciudad} es: ${detail.temperatura} y" +
                "${detail.detalles_tiempo.pronostico}"

        val uri = Uri.parse(
            "https://api.whatsapp.com/send?phone=$telefonoWsp&text=${
                URLEncoder.encode(
                    mensaje,
                    "UTF-8"
                )
            }"
        )
        val intent = Intent(Intent.ACTION_VIEW, uri)

        if(context?.let { intent.resolveActivity(it.packageManager) } != null ){
            startActivity(Intent.createChooser(intent, "Enviar por correo Sismo"))
        } else
            Toast.makeText(
                context,
                "Tienes que tener instalada una aplicación de correo",
                Toast.LENGTH_LONG
            ).show()
    }
}