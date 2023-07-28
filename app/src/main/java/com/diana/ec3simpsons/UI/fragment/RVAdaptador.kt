package com.diana.ec3simpsons.UI.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.diana.ec3simpsons.R
import com.diana.ec3simpsons.databinding.PersonajeItemBinding
import com.diana.ec3simpsons.model.Personaje

class RVAdaptador (var person:List<Personaje>): RecyclerView.Adapter<PersoVH>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersoVH {//asignar la vista
        val binding = PersonajeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersoVH(binding)
    }

    override fun getItemCount(): Int = person.size

    override fun onBindViewHolder(holder: PersoVH, position: Int) {//Colocar la Data en la vista
        holder.bind(person[position])

    }
}

class PersoVH(private val binding: PersonajeItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(personaje: Personaje) {
        binding.txtnompersona.text = personaje.nombre
        binding.txtgenero.text = personaje.genero
        binding.txtestado.text = personaje.estado
        binding.txtocupacion.text = personaje.ocupacion

        if(personaje.imagen.isNotEmpty()){
            binding.imgPersonaje.load(personaje.imagen)
        }
        else{
            binding.imgPersonaje.setImageResource(R.drawable.defect)
        }
        //Para cambiar el boton fav
        /*
        if (producto.is_favorite){
            binding.btnfav.setImageResource(R.drawable.icon_fav)
        }
        else{
            binding.btnfav.setImageResource(R.drawable.icon_fav_vacio)
        }*/
    }

}