package com.example.galeria

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.squareup.moshi.Moshi
import com.squareup.moshi.addAdapter
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val PREF = "MY_PREFERENCES"
    private val USR_FAV = "USR_FAVS"
    private lateinit var preferences: SharedPreferences
    private lateinit var detalles: Array<Detalles>
    private val moshi = Moshi.Builder().build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = getSharedPreferences(PREF, Context.MODE_PRIVATE)
        detalles=getFavPreferences()
        supportFragmentManager.beginTransaction().add(R.id.container, GaleriaFragment().apply {
            arguments = Bundle().apply {
                putParcelableArray("lista", detalles)
            }
        }).commit()
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    fun saveFavPreferences(detalles: Array<Detalles>?=null){
        preferences.edit().putString(USR_FAV, moshi.adapter(Array<Detalles>::class.java).toJson(detalles)).apply()
    }

    fun getFavPreferences() =
        preferences.getString(USR_FAV, null)?.let{
            return@let try {
                moshi.adapter(Detalles.listaImagenes::class.java).fromJson(it)
            }catch (e: Exception){
                Detalles.listaImagenes
            }
        }?:Detalles.listaImagenes
}