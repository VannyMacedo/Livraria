package com.projeto.sacrabooks

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class InformacoesFragment : Fragment() {

    private lateinit var bothome: ImageView
    private lateinit var botfavoritos: ImageView
    private lateinit var botsacola: ImageView
    private lateinit var botsalvar: Button
    private lateinit var editNomeLivro: EditText
    private lateinit var editNomeAutor: EditText

    val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout do fragmento de sacola
        val view = inflater.inflate(R.layout.activity_main_informacoes, container, false)

        bothome = view.findViewById(R.id.homeee)
        botfavoritos = view.findViewById(R.id.imageView12Teste)
        botsacola = view.findViewById(R.id.imageView12Ok)
        botsalvar = view.findViewById(R.id.salvarbutton)
        editNomeLivro = view.findViewById(R.id.nomelivro)
        editNomeAutor = view.findViewById(R.id.nomeautor)

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

        botsalvar.setOnClickListener {
            val intencao = hashMapOf(
                "nomeLivro" to editNomeLivro.text.toString(),
                "nomeAutor" to editNomeAutor.text.toString(),
            )

            db.collection("livros")
                .add(intencao)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }


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
