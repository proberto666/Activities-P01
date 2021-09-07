package com.example.galeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class InformacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        setView()
    }

    private lateinit var imgViewer : ImageView
    private lateinit var txvTitulo : TextView
    private lateinit var txvDescripción : TextView
    private lateinit var detalles: Detalles

    private fun setView(){



        detalles = intent.getParcelableExtra("detalleImagen")?:Detalles()
        imgViewer=findViewById(R.id.imgView)
        txvTitulo=findViewById(R.id.txvTitulo)
        txvDescripción=findViewById(R.id.txvDescription)

        printInfo()

        imgViewer.setOnClickListener{
            startActivity(Intent(this, ImagenActivity::class.java).apply {
                putExtra("Imagen", detalles)
            })
        }


    }

    private fun printInfo(){
        imgViewer.setImageResource(detalles.src!!.imagen)
        txvTitulo.text=detalles.titulo
        txvDescripción.text=detalles.descripcion
    }
}