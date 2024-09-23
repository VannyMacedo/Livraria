package com.projeto.sacrabooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class DetalhesFragment2 : Fragment() {

    private lateinit var voltarhome: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout do fragmento de detalhes
        val view = inflater.inflate(R.layout.activity_main_detalhes2, container, false)

        voltarhome = view.findViewById(R.id.imageView5)

        // Define o clique para navegar de volta ao HomeFragment
        voltarhome.setOnClickListener {
            loadFragment(HomeFragment())
        }

        // Ajuste de padding para system bars (barras de sistema)
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.imageView5)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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
