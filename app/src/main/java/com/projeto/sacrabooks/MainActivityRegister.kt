package com.projeto.sacrabooks

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var btnCamera: Button
    private lateinit var ivPhoto: ImageView

    private val REQUEST_IMAGE_CAPTURE = 171089

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_register, container, false)

        // Initialize views
        loginButton = view.findViewById(R.id.registerButton2)
        registerButton = view.findViewById(R.id.registerButton)
        emailEditText = view.findViewById(R.id.emailEditText)
        passwordEditText = view.findViewById(R.id.passwordEditText)
        btnCamera = view.findViewById(R.id.btncamera)
        ivPhoto = view.findViewById(R.id.ivphoto)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Handle login button click
        loginButton.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivityLogin::class.java)
            startActivity(intent)
        }

        // Handle camera button click
        btnCamera.setOnClickListener {
            dispatchTakePictureIntent()
        }

        // Handle registration logic
        registerButton.setOnClickListener {
            registerUser()
        }

        return view
    }

    // Dispatches the camera intent
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            activity?.packageManager?.let {
                takePictureIntent.resolveActivity(it)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    // Handles the result of the camera activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == AppCompatActivity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            ivPhoto.setImageBitmap(imageBitmap)
        }
    }

    // Register user with Firebase
    private fun registerUser() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(requireContext(), "Registrado com sucesso", Toast.LENGTH_SHORT).show()
                        activity?.finish() // Close the activity
                    } else {
                        Toast.makeText(requireContext(), "Erro ao registrar", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }
}
