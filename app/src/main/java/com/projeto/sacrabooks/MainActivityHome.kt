package com.projeto.sacrabooks

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.projeto.sacrabooks.R

class MainActivityHome : AppCompatActivity() {

    private lateinit var prosseguir: ImageView
    private lateinit var login: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_home)

        prosseguir = findViewById(R.id.imageViewCafe)
        login = findViewById(R.id.imageViewLogin)

        prosseguir.setOnClickListener {
            val proximaTela = Intent(this, MainActivityDetalhes::class.java)
            startActivity(proximaTela)
        }

        login.setOnClickListener {
            val proximaTela = Intent(this, MainActivityLogin::class.java)
            startActivity(proximaTela)
        }
    }
}

