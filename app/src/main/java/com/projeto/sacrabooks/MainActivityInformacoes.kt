package com.projeto.sacrabooks

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityInformacoes:AppCompatActivity() {

    private lateinit var bothome: ImageView
    private lateinit var botfavoritos: ImageView
    private lateinit var botsacola: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_informacoes)

        bothome = findViewById(R.id.homeee)
        botfavoritos = findViewById(R.id.imageView12Teste)
        botsacola = findViewById(R.id.imageView12Ok)

        bothome.setOnClickListener {
            val proximaTela = Intent(this, MainActivityHome::class.java)
            startActivity(proximaTela)
        }

        botfavoritos.setOnClickListener {
            val proximaTela = Intent(this, MainActivityFavoritos::class.java)
            startActivity(proximaTela)
        }
        botsacola.setOnClickListener {
            val proximaTela = Intent(this, MainActivitySacola::class.java)
            startActivity(proximaTela)
        }

    }

}