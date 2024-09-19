package com.projeto.sacrabooks

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivityHome : AppCompatActivity() {

    private lateinit var prosseguir: ImageView
    private lateinit var register: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_home)

        prosseguir = findViewById(R.id.imageViewCafe)
        register = findViewById(R.id.imageLogin)

        prosseguir.setOnClickListener {
            val proximaTela = Intent(this, MainActivityDetalhes::class.java)
            startActivity(proximaTela)
        }

        register.setOnClickListener {
            val proximaTela = Intent(this, MainActivityRegister::class.java)
            startActivity(proximaTela)
        }
    }
}


