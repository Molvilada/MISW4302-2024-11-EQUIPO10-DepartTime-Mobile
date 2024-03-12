package com.misoux.departtime

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ToolbarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toolbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Encuentra el botón de cerrar sesión y establece un ClickListener
        view.findViewById<TextView>(R.id.tvCerrarSesion).setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        // Aquí puedes agregar la lógica para limpiar cualquier dato de sesión o preferencias
        // ...

        // Inicia MainActivity y limpia la pila de backstack para que el usuario no pueda volver a esta actividad
        val intent = Intent(activity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
