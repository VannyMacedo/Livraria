package com.projeto.sacrabooks
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.projeto.sacrabooks.R

class MainActivityLogin : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Make sure activity_login.xml matches the XML file

        // Initialize FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Match the XML components
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgotPasswordTextView)
        val signUpTextView = findViewById<TextView>(R.id.signUpTextView)

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

        // Navigate to the registration screen
        signUpTextView.setOnClickListener {
            val intent = Intent(this, MainActivityRegister::class.java)
            startActivity(intent)
        }

        // Forgot password logic (optional)
        forgotPasswordTextView.setOnClickListener {
            // Add forgot password functionality here if needed
        }
    }
}
