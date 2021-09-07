package com.example.galeria

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Detalles (
    var titulo:String = "",
    var src: Imagenes? = null,
    var descripcion:String = ""
):Parcelable  {
    companion object {
        val listaImagenes = arrayOf(
            Detalles(
                "Gato Colmillos",
                src = Imagenes.COLMILLOS,
                "Un gato enseñado los colmillos"
            ),
            Detalles(
                "Perrito del Futuro",
                src = Imagenes.FUTUROG,
                "Perrito que viene del futuro"
            ),
            Detalles(
                "Close up de un Gato",
                src = Imagenes.GATOCAM,
                "Este gato puede ver tus pensamientos"
            ),
            Detalles(
                "Gato Triste",
                src = Imagenes.TRISTE,
                "Este gato esta triste"
            ),
            Detalles(
                "Perro mirando a una dirección",
                src = Imagenes.PERROCTOR,
                "Este perro puede estar buscando algo"
            ),
            Detalles(
                "Gato suave",
                src = Imagenes.CATCAT,
                "Este gato se ve muy suave"
            ),
            Detalles(
                "Rana saltando",
                src = Imagenes.RANA,
                "Este rana esta saltando al exito"
            ),
            Detalles(
                "Gato Suerte",
                src = Imagenes.MIAU,
                "Este gato esta puede darte buena suerte"
            )

        )
    }


}