package com.example.galeria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class GaleriaFragment : Fragment() {

    private lateinit var detalles: Array<Detalles>
    private lateinit var btnSiguiente: Button
    private lateinit var btnAnterior: Button
    private lateinit var btnInformacion: Button
    private lateinit var imgViewer: ImageView
    private lateinit var imgSound : ImageView
    private lateinit var imgFav : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalles = requireArguments().getParcelableArray("lista") as Array<Detalles>
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity?)?.saveFavPreferences(detalles)
        val view:View= inflater.inflate(R.layout.fragment_galeria, container, false)
        var i = 0;
        btnAnterior = view.findViewById(R.id.btnAnterior)
        btnSiguiente = view.findViewById(R.id.btnSiguiente)
        btnInformacion= view.findViewById(R.id.btnInfo)
        imgViewer = view.findViewById(R.id.imgView)
        imgSound=view.findViewById(R.id.imgSonido)
        imgFav=view.findViewById(R.id.imgFavorito)


        imgViewer.setImageResource(detalles[i].src!!.imagen)

        btnAnterior.setOnClickListener {
            i=ImagenAnterior(i)
            imgViewer.setImageResource(detalles[i].src!!.imagen)
        }

        btnSiguiente.setOnClickListener {
            i=ImagenSiguiente(i)
            imgViewer.setImageResource(detalles[i].src!!.imagen)
        }

        btnInformacion.setOnClickListener {
            (activity as MainActivity?)?.replaceFragment(
                InformacionFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable("detalles", detalles[i])
                    }
                }
            )
        }

       return view
    }


    private fun ImagenAnterior(i:Int):Int{
        var k = i
        if(k==0){
            k=detalles.size-1
        }else {
            k -= 1
        }
        return k
    }

    private fun ImagenSiguiente(i:Int):Int{
        var k = i
        if(k==detalles.size-1){
            k=0
        }else {
            k += 1
        }
        return k
    }

}