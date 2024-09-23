package com.projeto.sacrabooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class InformacoesFragment : Fragment() {

    private lateinit var bothome: ImageView
    private lateinit var botfavoritos: ImageView
    private lateinit var botsacola: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout do fragmento de sacola
        val view = inflater.inflate(R.layout.activity_main_sacola, container, false)

        bothome = view.findViewById(R.id.homeee)
        botfavoritos = view.findViewById(R.id.imageView12Teste)
        botsacola = view.findViewById(R.id.imageView12Ok)

        // Define o clique para navegar para HomeFragment
        bothome.setOnClickListener {
            loadFragment(HomeFragment())
        }

        // Define o clique para navegar para FavoritosFragment
        botfavoritos.setOnClickListener {
            loadFragment(FavoritosFragment())
        }

        // Define o clique para navegar para InformacoesFragment
        botsacola.setOnClickListener {
            loadFragment(SacolaFragment())
        }

        return view
    }

    // Método para trocar fragmentos
    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
