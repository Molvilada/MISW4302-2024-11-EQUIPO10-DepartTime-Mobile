package com.misoux.departtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//CITA MEDICA
class AlarmDetailActivitySecondScreen: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_detail_second_screen)

        if (savedInstanceState == null) {
            val toolbarFragment = ToolbarFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.toolbar_fragment_container, toolbarFragment)
                .commit()
        }
    }
}