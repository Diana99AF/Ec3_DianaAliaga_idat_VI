package com.diana.ec3simpsons.model

import com.google.gson.annotations.SerializedName

data class Personaje(
    @SerializedName("_id")
    val id: String,
    @SerializedName("Nombre")
    val nombre:String,
    @SerializedName("Historia")
    val historia:String,
    @SerializedName("Imagen")
    val imagen: String,
    @SerializedName("Genero")
    val genero: String,
    @SerializedName("Estado")
    val estado: String,
    @SerializedName("Ocupacion")
    val ocupacion:String

)

