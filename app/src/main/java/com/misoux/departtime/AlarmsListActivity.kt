package com.misoux.departtime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AlarmsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarms_list)

        val addAlarmButton = findViewById<FloatingActionButton>(R.id.add_alarm)

        addAlarmButton.setOnClickListener {
            val intent = Intent(this, CreateAlarmActivity::class.java)
            startActivity(intent)
        }

        if (savedInstanceState == null) {
            val toolbarFragment = ToolbarFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.toolbar_fragment_container, toolbarFragment)
                .commit()
        }
    }
}


