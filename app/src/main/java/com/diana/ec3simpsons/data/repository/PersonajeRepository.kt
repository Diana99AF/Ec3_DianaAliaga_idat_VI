package com.diana.ec3simpsons.data.repository

import com.diana.ec3simpsons.data.DatosResults
import com.diana.ec3simpsons.data.response.ListaPersonajeResponse
import com.diana.ec3simpsons.data.retrofit.RetrofitHelper

class PersonajeRepository {
    suspend fun getPersonajes():DatosResults<ListaPersonajeResponse>{
        return try {
            val response = RetrofitHelper.simpsonsInstance.getAllPersonajes()
            DatosResults.Success(response)
        }catch (e: Exception){
            DatosResults.Error(e)
        }


    }
}