package com.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui.databinding.ActivityDetailBinding
import com.example.ui.databinding.ActivitySecondBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DetailActivity.inflate(layoutInflater)
        setContentView(binding.root)
    }
}