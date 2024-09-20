package com.projeto.sacrabooks

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityDetalhes2: AppCompatActivity() {

    private lateinit var voltarhome: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_detalhes2)

        voltarhome = findViewById(R.id.imageView5)

        voltarhome.setOnClickListener {
            val proximaTela = Intent(this, MainActivityHome::class.java)
            startActivity(proximaTela)
        }
    }
}
