package com.diana.ec3simpsons.UI.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diana.ec3simpsons.data.DatosResults
import com.diana.ec3simpsons.data.repository.PersonajeRepository
import com.diana.ec3simpsons.model.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InicioViewModel:ViewModel() {
    val personajes : MutableLiveData<List<Personaje>> = MutableLiveData<List<Personaje>>()

    val repository = PersonajeRepository()

    /*
    fun getProductos(){//Se actualiza la data
        val allProductos = getData()
        productos.value = allProductos
    }*/

    //CoRutinas
    fun getPersonajeFromService(){
        viewModelScope.launch( Dispatchers.IO) {
            val response = repository.getPersonajes()

            when(response){
                is DatosResults.Success -> {
                    personajes.postValue(response.data.docs)
                }
                is DatosResults.Error -> {

                }

            }
            //    productos.postValue(response)
        }
    }
}