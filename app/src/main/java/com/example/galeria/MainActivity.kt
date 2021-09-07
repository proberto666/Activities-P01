package com.example.galeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var detalles: Array<Detalles>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        detalles=Detalles.listaImagenes
        initView()
    }

    private lateinit var btnSiguiente:Button
    private lateinit var btnAnterior:Button
    private lateinit var btnInformacion:Button
    private lateinit var imgViewer:ImageView

    private fun initView(){
        var i = 0;
        btnAnterior = findViewById(R.id.btnAnterior)
        btnSiguiente = findViewById(R.id.btnSiguiente)
        btnInformacion=findViewById(R.id.btnInfo)
        imgViewer = findViewById(R.id.imgView)

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
            startActivity(Intent(this, InformacionActivity::class.java).apply {
                putExtra("detalleImagen", detalles[i])
            })
        }
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