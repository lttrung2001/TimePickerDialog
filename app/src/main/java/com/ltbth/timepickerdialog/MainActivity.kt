package com.ltbth.timepickerdialog

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.sql.Time
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val timeTextView: TextView = findViewById(R.id.time_text)
        val button: Button = findViewById(R.id.btn_select_time)


        val n = Calendar.getInstance()
        var prevHour = n.get(Calendar.HOUR_OF_DAY)
        var prevMinute = n.get(Calendar.MINUTE)


        val listener = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            timeTextView.text = "$hourOfDay:$minute"
            prevHour = hourOfDay
            prevMinute = minute
        }
        val timePickerDialog = TimePickerDialog(this,
                                listener,
                                prevHour,
                                prevMinute,
                                true)

        button.setOnClickListener {
            timePickerDialog.show()
        }
    }
}