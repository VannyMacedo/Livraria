package com.projeto.projeto11

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivityHome : AppCompatActivity() {

    private lateinit var prosseguir: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_home)

        prosseguir = findViewById(R.id.imageViewCafe)

        prosseguir.setOnClickListener {

            val proximaTela = Intent(this, MainActivityDetalhes::class.java)

            startActivity(proximaTela)

        }
    }
}

