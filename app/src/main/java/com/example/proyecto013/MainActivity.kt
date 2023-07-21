package com.example.proyecto013

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var buttonSave: Button
    private lateinit var textViewLastEmail: TextView

    private val sharedPreferencesKey = "ultimo_correo"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSave = findViewById(R.id.buttonSave)
        textViewLastEmail = findViewById(R.id.textViewLastEmail)


        val sharedPreferences = getSharedPreferences("nombre", Context.MODE_PRIVATE)
        val UltimoCorreo = sharedPreferences.getString(sharedPreferencesKey, "")
        textViewLastEmail.text = "Último correo ingresado: $UltimoCorreo"

        buttonSave.setOnClickListener {

            val email = editTextEmail.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString(sharedPreferencesKey, email)
            editor.apply()


            Toast.makeText(this, "Correo electrónico guardado con éxito", Toast.LENGTH_SHORT).show()
        }
    }
}
