package com.example.galeria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ImagenFragment : Fragment() {

    private lateinit var imgViewer : ImageView
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
        val view : View = inflater.inflate(R.layout.fragment_imagen, container, false)
        imgViewer = view.findViewById(R.id.imgView)

        imgViewer.setImageResource(detalles.src!!.imagen)

        return view
    }
}