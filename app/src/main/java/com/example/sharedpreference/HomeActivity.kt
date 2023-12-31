package com.example.sharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val KEY_USERNAME = "user_name"
    private val KEY_PASSWORD = "pass_word"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref : SharedPreferences =
            getSharedPreferences("my_pref", MODE_PRIVATE)

        val username = pref.getString(KEY_USERNAME,null)
        val password = pref.getString(KEY_PASSWORD,null)

        binding.txtUserName.text = username
        binding.txtPassword.text = password

    }
}