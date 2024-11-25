package com.example.menu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    //Declaramos los botones
    private  lateinit var buton1:Button
    private  lateinit var buton2:Button
    private  lateinit var buton3:Button
    private  lateinit var buton4:Button
    private  lateinit var buton5:Button

    //Declaramos el text view
    private lateinit var texto:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
    }

    //Iniciamos LosComponentes
    private fun initComponents(){
        buton1=findViewById(R.id.buton1)
        buton2=findViewById(R.id.buton2)
        buton3=findViewById(R.id.buton3)
        buton4=findViewById(R.id.buton4)
        buton5=findViewById(R.id.buton5)
        texto=findViewById(R.id.texto)
    }

    //Iniciamos Los Listeners
    private fun initListeners(){
        //Abre una nueva activity
        buton1.setOnClickListener(){
            val intentGA = Intent(this, MainActivity2::class.java)
            startActivity(intentGA)
        }

        //Muestra un toast
        buton2.setOnClickListener(){
            Toast.makeText(this, "Hola Soy un toast", Toast.LENGTH_LONG).show()
        }

        //Muestra un SnackBar
        buton3.setOnClickListener(){
            Snackbar.make(buton3, "Hola soy un Snackbar", Snackbar.LENGTH_SHORT).show()
        }

        //Cierra la aplicacion
        buton4.setOnClickListener(){
            onDestroy()
        }
        //Muestra y oculta el texto
        buton5.setOnClickListener(){
            if (texto.visibility== View.VISIBLE){
                texto.visibility=View.INVISIBLE
            }else{
                texto.visibility=View.VISIBLE
            }
        }
    }
}