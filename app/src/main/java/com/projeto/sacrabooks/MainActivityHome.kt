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
    private lateinit var prosseguir2: ImageView
    private lateinit var prosseguir3: ImageView
    private lateinit var prosseguir4: ImageView
    private lateinit var botsacola: ImageView
    private lateinit var botfavoritos: ImageView
    private lateinit var botinformacoes: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_home)

        prosseguir = findViewById(R.id.imageViewCafe)
        register = findViewById(R.id.imageView20)
        prosseguir2 = findViewById(R.id.imageView21)
        prosseguir3 = findViewById(R.id.imageView22)
        prosseguir4 = findViewById(R.id.imageView23)
        botsacola = findViewById(R.id.imageView12Ok)
        botfavoritos = findViewById(R.id.imageView12Teste)
        botinformacoes = findViewById(R.id.imageView12Otimo)

        prosseguir.setOnClickListener {
            val proximaTela = Intent(this, MainActivityDetalhes::class.java)
            startActivity(proximaTela)
        }

        register.setOnClickListener {
            val proximaTela = Intent(this, MainActivityRegister::class.java)
            startActivity(proximaTela)
        }
        prosseguir2.setOnClickListener {
            val proximaTela = Intent(this, MainActivityDetalhes2::class.java)
            startActivity(proximaTela)
        }

        prosseguir3.setOnClickListener {
            val proximaTela = Intent(this, MainActivityDetalhes3::class.java)
            startActivity(proximaTela)
        }

        prosseguir4.setOnClickListener {
            val proximaTela = Intent(this, MainActivityDetalhes4::class.java)
            startActivity(proximaTela)
        }

        botsacola.setOnClickListener {
            val proximaTela = Intent(this, MainActivitySacola::class.java)
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

