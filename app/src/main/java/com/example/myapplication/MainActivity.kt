package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihanpref.PrefManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = PrefManager(this).sharedPref
        val isFirsTime = pref.getBoolean(PrefManager.IS_FIRST_TIME, true)

        if (!isFirsTime) startActivity(Intent(this, HomeActivity::class.java))

        binding.btnNext.setOnClickListener {
            val editor = pref.edit()
            editor.putBoolean(PrefManager.IS_FIRST_TIME, false)
            editor.apply()
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}