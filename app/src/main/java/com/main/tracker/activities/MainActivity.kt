package com.main.tracker.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.main.tracker.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_addnew)
        button.setOnClickListener{
            val intent = Intent(this, NextExpectedCycleActivity::class.java)
            startActivity(intent);
        }

    }
}