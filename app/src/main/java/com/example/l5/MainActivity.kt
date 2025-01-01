package com.example.l5

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.buttonExample);
        // Set an onClickListener using a lambda
        button.setOnClickListener {
            // Display a Toast message on button click
            Toast.makeText(applicationContext, "Button Clicked", Toast.LENGTH_SHORT).show()
        }





    }
}