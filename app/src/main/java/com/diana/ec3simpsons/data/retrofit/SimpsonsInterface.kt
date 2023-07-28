package com.diana.ec3simpsons.data.retrofit

import com.diana.ec3simpsons.data.response.ListaPersonajeResponse
import retrofit2.http.GET

interface SimpsonsInterface {
    @GET("api/personajes")
    suspend fun getAllPersonajes(): ListaPersonajeResponse
}