package com.example.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.servicedemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val serviceIntent = Intent(this, MyBackgroundService::class.java)
        serviceIntent.putExtra(MyBackgroundService.Name, "Alex")
        serviceIntent.putExtra(MyBackgroundService.MARKS, 79)
        binding.btnStart.setOnClickListener {
            Log.i(MyBackgroundService.TAG, "Starting service")
            startService(serviceIntent)
        }
        binding.btnStop.setOnClickListener {
        Log.i(MyBackgroundService.TAG, "Stopping service")
            stopService(serviceIntent)
        }
    }
}