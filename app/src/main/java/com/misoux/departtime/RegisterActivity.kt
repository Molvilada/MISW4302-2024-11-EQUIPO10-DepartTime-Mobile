package com.misoux.departtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class RegisterActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry_page)

        val registerButton = findViewById<Button>(R.id.register_button)
        val loginTextView = findViewById<TextView>(R.id.login_text_action)

        registerButton.setOnClickListener {
            val intent = Intent(this, AlarmsListActivity::class.java)
            startActivity(intent)
        }

        loginTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}