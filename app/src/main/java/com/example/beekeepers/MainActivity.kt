package com.example.beekeepers

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.beekeepers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            ItemData(R.drawable.beekepoers, "17.08.2024 Köyceğiz MUĞLA", "No description..."),
            ItemData(R.drawable.beekepoers, "17.08.2024 Köyceğiz MUĞLA", "No description..."),
            // Diğer öğeler...
        )

        val adapter = MainpageAdapter(this, items)
        binding.gridLayout.adapter = adapter
    }
}