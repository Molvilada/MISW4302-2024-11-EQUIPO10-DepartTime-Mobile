package com.misoux.departtime

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
import androidx.core.util.Pair
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.Calendar


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
        val dropdownMenuInput = findViewById<TextInputLayout>(R.id.dropdown_menu)
        val checkBox = findViewById<CheckBox>(R.id.check_in_advance)
        dropdownMenu.setAdapter(adapter)

        dropdownMenu.setText("5 minutos", false)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            dropdownMenuInput.isEnabled = isChecked
        }

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.dropdown_autocomplete)

        val dropDownBackground = ColorDrawable(ContextCompat.getColor(this, R.color.surface))
        autoCompleteTextView.setDropDownBackgroundDrawable(dropDownBackground)


        val buttonCalendar: MaterialButton = findViewById(R.id.button_calendar)

        val constraintsBuilder = CalendarConstraints.Builder()
            .setOpenAt(MaterialDatePicker.todayInUtcMilliseconds())
            .setValidator(DateValidatorPointForward.now())

        buttonCalendar.setOnClickListener {
            val datePickerDialog = MaterialDatePicker.Builder.datePicker()
                .setTheme(R.style.CustomMaterialDatePickerStyle)
                .setTitleText("Selecciona una fecha")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setCalendarConstraints(constraintsBuilder.build())
                .build()


            datePickerDialog.show(supportFragmentManager, "datePicker")
        }

        val now = Calendar.getInstance()
        val currentHour = now.get(Calendar.HOUR_OF_DAY)
        val currentMinute = now.get(Calendar.MINUTE)

        val buttonDepartureTime: MaterialButton = findViewById(R.id.button_departure_time)
        buttonDepartureTime.setOnClickListener {
            val materialTimePicker = MaterialTimePicker.Builder()
                .setTheme(R.style.CustomMaterialTimePickerStyle)
                .setTitleText("Selecciona la hora de salida")
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(currentHour)
                .setMinute(currentMinute)
                .build()

            materialTimePicker.show(supportFragmentManager, "MaterialTimePicker")

        }

    }
}