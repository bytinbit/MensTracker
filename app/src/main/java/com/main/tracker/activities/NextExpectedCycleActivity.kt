package com.main.tracker.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.main.tracker.R
import com.main.tracker.model.Cycle
import com.main.tracker.model.CycleRepository
import com.main.tracker.helpers.Converter.convertDatetoLocalDate
import com.squareup.timessquare.CalendarPickerView
import java.text.DateFormat
import java.time.LocalDate
import java.util.*


class NextExpectedCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextexpectedcycle)

        val today = Date()
        val nextYear = Calendar.getInstance()
        nextYear.add(Calendar.YEAR,1)
        val datePicker = findViewById<CalendarPickerView>(R.id.calendar)
        datePicker.init(today, nextYear.time)


        datePicker.setOnDateSelectedListener(object: CalendarPickerView.OnDateSelectedListener {
            override fun onDateSelected(date: Date) {
                val selectedDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date)
                Toast.makeText(this@NextExpectedCycleActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }

            override fun onDateUnselected(date: Date) {
            }
        })

        val abortButton = findViewById<Button>(R.id.abortButton1)
        abortButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val finishButton = findViewById<Button>(R.id.addExpectedButton)
        finishButton.setOnClickListener{
            val expected = convertDatetoLocalDate(datePicker.selectedDate)
            addNewCycleEntry(expected)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }

    private fun addNewCycleEntry(chosenExpectedDate: LocalDate) {
        val cycle = Cycle(chosenExpectedDate, null, null)
        CycleRepository.addCycle(cycle)
    }

}