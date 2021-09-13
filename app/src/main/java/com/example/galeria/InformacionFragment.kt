package com.example.galeria

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class InformacionFragment : Fragment() {

    private lateinit var imgViewer : ImageView
    private lateinit var txvTitulo : TextView
    private lateinit var txvDescripcion : TextView
    private lateinit var imgSound : ImageView
    private lateinit var imgFav : ImageView
    private lateinit var detalles: Detalles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalles = requireArguments().getParcelable("detalles")?: Detalles()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_informacion, container, false)

        imgViewer=view.findViewById(R.id.imgView)
        txvTitulo=view.findViewById(R.id.txvTitulo)
        txvDescripcion=view.findViewById(R.id.txvDescription)
        imgSound=view.findViewById(R.id.imgSonido)
        imgFav=view.findViewById(R.id.imgFavorito)

        printInfo()

        imgSound.setOnClickListener{
            if(detalles.favSound){
                imgSound.setImageResource(R.drawable.ic_baseline_playlist_add_24)
                detalles.favSound=false
            }else{
                imgSound.setImageResource(R.drawable.ic_baseline_remove_24)
                detalles.favSound=true
            }
        }

        imgFav.setOnClickListener{
            if(detalles.favImg){
                imgFav.setImageResource(R.drawable.ic_baseline_star_outline_24)
                detalles.favImg=false
            }else{
                imgFav.setImageResource(R.drawable.ic_baseline_star_24)
                detalles.favImg=true
            }
        }

        imgViewer.setOnClickListener{
            (activity as MainActivity?)?.replaceFragment(
                ImagenFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable("imagen", detalles)
                    }
                }
            )
        }
        return view
    }

    private fun printInfo(){
        MediaPlayer.create(activity,detalles.src!!.sound).start()
        imgViewer.setImageResource(detalles.src!!.imagen)
        txvTitulo.text=detalles.titulo
        txvDescripcion.text=detalles.descripcion

        if(detalles.favSound){
            imgSound.setImageResource(R.drawable.ic_baseline_remove_24)
        }else{
            imgSound.setImageResource(R.drawable.ic_baseline_playlist_add_24)
        }
        if(detalles.favImg){
            imgFav.setImageResource(R.drawable.ic_baseline_star_24)
        }else{
            imgFav.setImageResource(R.drawable.ic_baseline_star_outline_24)
        }
    }

}