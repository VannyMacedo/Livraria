package com.projeto.sacrabooks

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.graphics.Bitmap
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivityRegister : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var login: Button
    val REQUEST_IMAGE_CAPTURE = 171089

    private fun dispatchTakePictureIntent(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            this.let {
                takePictureIntent.resolveActivity(it.packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == -1){
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val ivphoto = findViewById<ImageView>(R.id.ivphoto)
            ivphoto.setImageBitmap(imageBitmap)
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        login = findViewById(R.id.registerButton2)

        login.setOnClickListener {
            val proximaTela = Intent(this, MainActivityLogin::class.java)
            startActivity(proximaTela)
        }

        // Inicializa o FirebaseAuth
        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val btncamera = findViewById<Button>(R.id.btncamera)

        btncamera.setOnClickListener{
            dispatchTakePictureIntent()
        }

        // Lógica de Registro
        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Registro bem-sucedido
                            Toast.makeText(this, "Registrado com sucesso", Toast.LENGTH_SHORT).show()
                            finish() // Fecha a activity de registro
                        } else {
                            // Falha no registro
                            Toast.makeText(this, "Erro ao registrar", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}