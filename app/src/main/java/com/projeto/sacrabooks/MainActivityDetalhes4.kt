package com.projeto.sacrabooks

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivityDetalhes4:  AppCompatActivity() {

    private lateinit var voltarhomee: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_detalhes4)

        voltarhomee = findViewById(R.id.imageView12)

        voltarhomee.setOnClickListener {
            val proximaTela = Intent(this, MainActivityHome::class.java)
            startActivity(proximaTela)
        }

    }
}