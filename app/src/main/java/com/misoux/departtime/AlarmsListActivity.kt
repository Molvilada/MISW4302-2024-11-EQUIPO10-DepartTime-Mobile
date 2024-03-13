package com.misoux.departtime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AlarmsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarms_list)

        val addAlarmButton = findViewById<FloatingActionButton>(R.id.add_alarm)
        val alarmTrabajoLinearLayout = findViewById<LinearLayout>(R.id.alarm_trabajo)
        val alarmCitaMedicaLinearLayout = findViewById<LinearLayout>(R.id.alarm_medical)

        addAlarmButton.setOnClickListener {
            val intent = Intent(this, CreateAlarmActivity::class.java)
            startActivity(intent)
        }

        alarmTrabajoLinearLayout.setOnClickListener {
            val intent = Intent(this, AlarmDetailActivityFirstScreen::class.java)
            startActivity(intent)
        }

        alarmCitaMedicaLinearLayout.setOnClickListener {
            val intent = Intent(this, AlarmDetailActivitySecondScreen::class.java)
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


