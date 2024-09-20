package com.projeto.sacrabooks

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivityFavoritos: AppCompatActivity() {

    private lateinit var bothome: ImageView
    private lateinit var botsacola: ImageView
    private lateinit var botinformacoes: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_favoritos)

        bothome = findViewById(R.id.homeee)
        botsacola = findViewById(R.id.imageView12Ok)
        botinformacoes = findViewById(R.id.imageView12Otimo)

        bothome.setOnClickListener {
            val proximaTela = Intent(this, MainActivityHome::class.java)
            startActivity(proximaTela)
        }

        botsacola.setOnClickListener {
            val proximaTela = Intent(this, MainActivitySacola::class.java)
            startActivity(proximaTela)
        }

        botinformacoes.setOnClickListener {
            val proximaTela = Intent(this, MainActivityInformacoes::class.java)
            startActivity(proximaTela)
        }

    }
}