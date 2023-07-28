package com.diana.ec3simpsons.UI.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diana.ec3simpsons.R
import com.diana.ec3simpsons.databinding.FragmentInicioBinding


class InicioFragment : Fragment() {
    private lateinit var binding: FragmentInicioBinding
    private lateinit var viewModel: InicioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[InicioViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RVAdaptador(listOf())
        binding.rvPersonajes.adapter = adapter

        //binding.rvProductos.adapter = RVAdaptador(getData())
        binding.rvPersonajes.layoutManager = GridLayoutManager(requireContext(),2,
            RecyclerView.VERTICAL,false) //para que se vea una lista de dos columnas


        viewModel.personajes.observe(requireActivity()){persona->
            adapter.person = persona

            adapter.notifyDataSetChanged()
        }
        viewModel.getPersonajeFromService()
    }


}