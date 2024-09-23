package com.projeto.sacrabooks
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.projeto.sacrabooks.R

class MainActivityLogin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var register: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        register = findViewById(R.id.registerButton3)

        register.setOnClickListener {
            val proximaTela = Intent(this, RegisterFragment::class.java)
            startActivity(proximaTela)
        }

        // Initialize FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Match the XML components
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgotPasswordTextView)

        // Login logic
        loginButton.setOnClickListener {
            val email = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Successful login
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish() // Close login activity
                        } else {
                            // Login failed
                            Toast.makeText(this, "Erro ao fazer login", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Forgot password logic (optional)
        forgotPasswordTextView.setOnClickListener {
            // Add forgot password functionality here if needed
        }
    }
}
