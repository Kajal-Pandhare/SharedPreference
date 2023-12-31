package com.example.sharedpreference

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val KEY_USERNAME = "user_name"
    private val KEY_PASSWORD = "pass_word"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initListener()
    }
    private fun initViews(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val pref : SharedPreferences =
//            getSharedPreferences("my_pref", MODE_PRIVATE)

//        binding.edtUserName.setText(pref.getString(KEY_USERNAME,null))
//        binding.edtPassword.setText(pref.getString(KEY_PASSWORD,null))
    }
    private fun initListener(){
        val pref : SharedPreferences =
            getSharedPreferences("my_pref", MODE_PRIVATE)


        binding.btnLogin.setOnClickListener {
            val editor = pref.edit()

            editor.putString(KEY_USERNAME,binding.edtUserName.text.toString())
            editor.putString(KEY_PASSWORD,binding.edtPassword.text.toString())
            editor.apply()

            val intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
            mt()
        }
    }
    private fun mt(){
        Toast.makeText(this,"Login Successfully",Toast.LENGTH_SHORT).show()
    }
}