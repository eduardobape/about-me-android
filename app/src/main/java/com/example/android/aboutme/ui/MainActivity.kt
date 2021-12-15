package com.example.android.aboutme.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.R
import com.example.android.aboutme.data.User
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        myUser = User("Pepe")
        binding.user = myUser
        binding.bShowNickname.setOnClickListener {
            showNickName()
        }
    }

    private fun showNickName() {
        myUser?.nickname = binding.etNickname.text.toString()
        binding.apply {
            invalidateAll()
            etNickname.visibility = View.GONE
            bShowNickname.visibility = View.GONE
            tvNickname.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}