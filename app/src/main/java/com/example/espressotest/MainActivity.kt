package com.example.espressotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.TV_hello)
        val edit = findViewById<EditText>(R.id.ET_input)
        val button = findViewById<Button>(R.id.BTN_click)

        button.setOnClickListener {

            if (edit.text.isNullOrEmpty()) Toast.makeText(this,"Cannot be empty",
                Toast.LENGTH_LONG).show()

            else {text.text = edit.text}
        }
    }
}