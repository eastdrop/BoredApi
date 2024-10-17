package com.example.m16_arch.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.m16_arch.R
import com.example.m16_arch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Используем ViewBinding для работы с макетом
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Проверяем, что Fragment еще не был добавлен
        if (savedInstanceState == null){
            supportFragmentManager.commit {
                // Добавляем MainFragment в контейнер
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragment_container)
                //replace(R.id.fragment_container, MainFragment())
            }
        }
    }
}