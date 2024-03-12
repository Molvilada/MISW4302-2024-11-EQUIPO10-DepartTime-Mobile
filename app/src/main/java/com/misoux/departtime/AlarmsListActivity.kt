package com.misoux.departtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AlarmsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarms_list)

        if (savedInstanceState == null) {
            val toolbarFragment = ToolbarFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.toolbar_fragment_container, toolbarFragment)
                .commit()
        }
    }
}


