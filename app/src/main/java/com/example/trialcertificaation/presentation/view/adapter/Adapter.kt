package com.example.trialcertificaation.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trialcertificaation.data.local.entities.LocalList
import com.example.trialcertificaation.databinding.ItemListBinding

/**
 * Adaptador para mostrar la lista de climas RecyclerView.
 */
class Adapter : RecyclerView.Adapter<Adapter.WeatherRecyclerView>() {
    //Referencias para el adapter
    private var weatherList = listOf<LocalList>()
    private val weatherCity = MutableLiveData<LocalList>()


    //Actualizar el adapter
    fun update(list: List<LocalList>) {
        weatherList = list
        notifyDataSetChanged()
    }


    fun selectCity(): LiveData<LocalList> = weatherCity


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherRecyclerView {
        return WeatherRecyclerView(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = weatherList.size

    override fun onBindViewHolder(holder: WeatherRecyclerView, position: Int) {
        val weather = weatherList[position]
        holder.bind(weather)
    }



    inner class WeatherRecyclerView(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(weather: LocalList) {
            Glide.with(binding.img).load(weather.imagen).centerCrop().into(binding.img)
            binding.textViewCity.text = weather.ciudad
            binding.textViewRegin.text = weather.region
            binding.textViewTemperature.text = weather.temperatura + "°C"

            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            weatherCity.value = weatherList[adapterPosition]
        }

    }


}