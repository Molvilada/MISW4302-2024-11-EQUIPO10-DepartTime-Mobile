package com.misoux.departtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra el botón por su ID
        val botonIniciarSesion = findViewById<Button>(R.id.login_button)

        // Establece un listener para manejar el evento de clic
        botonIniciarSesion.setOnClickListener {
            // Crea un Intent para abrir la NuevaActivity
            val intent = Intent(this, AlarmsListActivity::class.java)
            // Inicia la actividad
            startActivity(intent)
        }
    }
}