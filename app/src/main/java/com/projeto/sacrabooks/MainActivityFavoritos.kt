package com.projeto.sacrabooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FavoritosFragment : Fragment() {

    private lateinit var bothome: ImageView
    private lateinit var botsacola: ImageView
    private lateinit var botinformacoes: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout do fragmento de favoritos
        val view = inflater.inflate(R.layout.activity_main_favoritos, container, false)

        bothome = view.findViewById(R.id.homeee)
        botsacola = view.findViewById(R.id.imageView12Ok)
        botinformacoes = view.findViewById(R.id.imageView12Otimo)

        // Define os listeners para trocar os fragmentos
        bothome.setOnClickListener {
            loadFragment(HomeFragment())
        }

        botsacola.setOnClickListener {
            loadFragment(SacolaFragment())
        }

        botinformacoes.setOnClickListener {
            loadFragment(InformacoesFragment())
        }

        return view
    }

    // Função para trocar de fragmento
    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)  // Adiciona à pilha de navegação
            .commit()
    }
}
