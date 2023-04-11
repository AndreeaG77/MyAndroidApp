package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username: TextView = findViewById(R.id.username)
        val password: TextView = findViewById(R.id.password)
        val loginB: MaterialButton = findViewById(R.id.loginB)
    }
}