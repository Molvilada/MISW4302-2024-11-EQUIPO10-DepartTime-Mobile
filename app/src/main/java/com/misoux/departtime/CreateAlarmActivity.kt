package com.misoux.departtime

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CheckBox
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat

class CreateAlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_alarm)

        if (savedInstanceState == null) {
            val toolbarFragment = ToolbarFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.toolbar_fragment_container, toolbarFragment)
                .addToBackStack(null)
                .commit()
        }

        val items = listOf("5 minutos", "10 minutos", "15 minutos", "30 minutos", "1 hora")
        val adapter = ArrayAdapter(this, R.layout.dropdown_menu_popup_item, items)
        val dropdownMenu = findViewById<AutoCompleteTextView>(R.id.dropdown_autocomplete)
        val checkBox = findViewById<CheckBox>(R.id.check_in_advance)

        dropdownMenu.setAdapter(adapter)

        dropdownMenu.setText("5 minutos", false)

        dropdownMenu.isEnabled = checkBox.isChecked

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            dropdownMenu.isEnabled = isChecked

        }

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.dropdown_autocomplete)

        val dropDownBackground = ColorDrawable(ContextCompat.getColor(this, R.color.surface))
        autoCompleteTextView.setDropDownBackgroundDrawable(dropDownBackground)

    }
}