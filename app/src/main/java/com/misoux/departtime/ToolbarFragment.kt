package com.misoux.departtime

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

@Suppress("DEPRECATION")
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
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        view.findViewById<TextView>(R.id.tvCerrarSesion).setOnClickListener {
            logout()
        }

        view.findViewById<Toolbar>(R.id.toolbar).setOnClickListener{
            goBack()
        }

        when (activity) {
            is AlarmsListActivity -> {
                toolbar.navigationIcon = null
            }
        }
    }

    private fun goBack() {
        activity?.finish()
    }
    private fun logout() {
        val intent = Intent(activity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
