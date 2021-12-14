package com.example.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bShowNickname.setOnClickListener {
            showNickName()
        }
    }

    private fun showNickName() {
        binding.etNickname.visibility = View.GONE
        binding.bShowNickname.visibility = View.GONE
        binding.tvNickname.text = binding.etNickname.text.toString()
        binding.tvNickname.visibility = View.VISIBLE
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}