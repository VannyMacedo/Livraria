package com.projeto.sacrabooks

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivityHome : AppCompatActivity() {

    private lateinit var prosseguir: ImageView
    private lateinit var register: ImageView
    private lateinit var prosseguir2: ImageView
    private lateinit var prosseguir3: ImageView
    private lateinit var prosseguir4: ImageView
    private lateinit var botsacola: ImageView
    private lateinit var botfavoritos: ImageView
    private lateinit var botinformacoes: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        prosseguir = findViewById(R.id.imageViewCafe)
        register = findViewById(R.id.imageView20)
        prosseguir2 = findViewById(R.id.imageView21)
        prosseguir3 = findViewById(R.id.imageView22)
        prosseguir4 = findViewById(R.id.imageView23)
        botsacola = findViewById(R.id.imageView12Ok)
        botfavoritos = findViewById(R.id.imageView12Teste)
        botinformacoes = findViewById(R.id.imageView12Otimo)

        // Carregar o fragmento inicial
        loadFragment(HomeFragment())

        prosseguir.setOnClickListener {
            loadFragment(DetalhesFragment()) // Carrega o fragmento de Detalhes
        }

        register.setOnClickListener {
            loadFragment(RegisterFragment()) // Carrega o fragmento de Registro
        }

        prosseguir2.setOnClickListener {
            loadFragment(DetalhesFragment2()) // Carrega Detalhes 2
        }

        prosseguir3.setOnClickListener {
            loadFragment(DetalhesFragment3())
        }

        prosseguir4.setOnClickListener {
            loadFragment(DetalhesFragment4())
        }

        botsacola.setOnClickListener {
            loadFragment(SacolaFragment()) // Carrega o fragmento de Sacola
        }

        botfavoritos.setOnClickListener {
            loadFragment(FavoritosFragment()) // Carrega o fragmento de Favoritos
        }

        botinformacoes.setOnClickListener {
            loadFragment(InformacoesFragment()) // Carrega o fragmento de Informações
        }
    }

    // Função para carregar fragmentos
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
