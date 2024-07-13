package com.example.trialcertificaation.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trialcertificaation.presentation.view.adapter.Adapter
import com.example.trialcertificaation.presentation.viewmodel.ViewModel
import com.example.trialcertificaation.R
import com.example.trialcertificaation.databinding.FragmentFirstBinding

/**
 * Fragmento que muestra la lista de conciertos.
 */
class ListFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    private val viewModel: ViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = Adapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        //Actualizar el adapter
        viewModel.getListWeather().observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("Listado", it.toString())
                adapter.update(it)
            }
        })

        adapter.selectCity().observe(viewLifecycleOwner, Observer {
            it.let {
                Log.d("Seleccionado", it.toString())
            }
            //pasar id al segundo fragmento
            val bundle = Bundle().apply {
                putInt("idSelect", it.id)
            }

            //Navegar al segundo fragmento
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}