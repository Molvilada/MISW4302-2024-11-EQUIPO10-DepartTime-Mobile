package com.misoux.departtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val intent = Intent(this, AlarmsListActivity::class.java)
            startActivity(intent)
        }
    }
}