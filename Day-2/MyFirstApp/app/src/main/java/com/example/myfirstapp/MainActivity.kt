package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.Intent

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val btnChangeText = findViewById<Button>(R.id.btnChangeText)
        val btnCounter = findViewById<Button>(R.id.btnCounter)
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnNextScreen = findViewById<Button>(R.id.btnNextScreen)

        // 1️⃣ Change the text
        btnChangeText.setOnClickListener {
            tvMessage.text = "Text Changed!"
        }

        // 2️⃣ Increase counter
        btnCounter.setOnClickListener {
            counter++
            tvMessage.text = "Counter: $counter"
        }

        // 3️⃣ Show a Toast message
        btnToast.setOnClickListener {
            Toast.makeText(this, "Hello! This is a Toast.", Toast.LENGTH_SHORT).show()
        }

        // 4️⃣ Go to next screen
        btnNextScreen.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
