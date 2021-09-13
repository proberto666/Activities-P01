package com.example.galeria

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Detalles (
    var titulo:String = "",
    var src: Imagenes? = null,
    var favSound:Boolean = false,
    var favImg:Boolean = false,
    var descripcion:String = ""
):Parcelable  {
    companion object {
        val listaImagenes = arrayOf(
            Detalles(
                "Gato Colmillos",
                src = Imagenes.COLMILLOS,
                false,false,
                "Un gato enseñado los colmillos"
            ),
            Detalles(
                "Perrito del Futuro",
                src = Imagenes.FUTUROG,
                false,false,
                "Perrito que viene del futuro"
            ),
            Detalles(
                "Close up de un Gato",
                src = Imagenes.GATOCAM,
                false,false,
                "Este gato puede ver tus pensamientos"
            ),
            Detalles(
                "Gato Triste",
                src = Imagenes.TRISTE,
                false,false,
                "Este gato esta triste"
            ),
            Detalles(
                "Perro mirando a una dirección",
                src = Imagenes.PERROCTOR,
                false,false,
                "Este perro puede estar buscando algo"
            ),
            Detalles(
                "Gato suave",
                src = Imagenes.CATCAT,
                false,false,
                "Este gato se ve muy suave"
            ),
            Detalles(
                "Rana saltando",
                src = Imagenes.RANA,
                false,false,
                "Este rana esta saltando al exito"
            ),
            Detalles(
                "Gato Suerte",
                src = Imagenes.MIAU,
                false,false,
                "Este gato esta puede darte buena suerte"
            )

        )
    }


}