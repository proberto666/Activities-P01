package com.example.galeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImagenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen)

        setView()
    }

    private lateinit var imgView : ImageView
    private lateinit var detalles : Detalles

    fun setView(){
        detalles = intent.getParcelableExtra("Imagen")?:Detalles()
        imgView = findViewById(R.id.imgView)
        imgView.setImageResource(detalles.src!!.imagen)
    }
}