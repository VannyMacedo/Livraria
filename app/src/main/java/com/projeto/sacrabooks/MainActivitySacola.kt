package com.projeto.sacrabooks

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivitySacola:  AppCompatActivity() {

    private lateinit var bothome: ImageView
    private lateinit var botfavoritos: ImageView
    private lateinit var botinformacoes: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_sacola)

        bothome = findViewById(R.id.homeee)
        botfavoritos = findViewById(R.id.imageView12Teste)
        botinformacoes = findViewById(R.id.imageView12Otimo)


        bothome.setOnClickListener {
            val proximaTela = Intent(this, MainActivityHome::class.java)
            startActivity(proximaTela)
        }

        botfavoritos.setOnClickListener {
            val proximaTela = Intent(this, MainActivityFavoritos::class.java)
            startActivity(proximaTela)
        }

        botinformacoes.setOnClickListener {
            val proximaTela = Intent(this, MainActivityInformacoes::class.java)
            startActivity(proximaTela)
        }

    }
}