package com.example.beekeepers

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.beekeepers.databinding.ActivityViewTestResultsScreenBinding

class viewTestResultsScreen : AppCompatActivity() {
    private var _binding: ActivityViewTestResultsScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityViewTestResultsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ArrayAdapter.createFromResource(
            this,
            R.array.sorting_options,  // strings.xml içinde tanımlanan string-array
            android.R.layout.simple_spinner_item // Spinner'ın her bir öğesinin görünümü
        ).also { adapter ->
            // Dropdown görünümünü ayarla
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Spinner'a adapter'i ata
            binding.SortBy.adapter = adapter
        }

      binding.SortBy.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
          override  fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedOption = parent.getItemAtPosition(position).toString()
                // Seçilen sıralama seçeneğine göre işlem yapabilirsiniz
                Toast.makeText(this@viewTestResultsScreen, "Seçilen: $selectedOption", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Hiçbir şey seçilmediğinde yapılacak işlemler
            }




        }    // Spinner için seçenekler
        val seasons = arrayOf("2024-Yaz", "2024-Sonbahar", "2024-Kış", "2024-İlkbahar")

        // Adapter oluştur ve Spinner'a ata
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, seasons)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSeasons.adapter = adapter

        // Spinner öğesi tıklandığında yapılacak işlemler
        binding.spinnerSeasons.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedSeason = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@viewTestResultsScreen, "Seçilen mevsim: $selectedSeason", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Hiçbir şey seçilmediğinde yapılacak işlemler
            }
        }






    }
    fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        val selectedOption = parent.getItemAtPosition(position).toString()

        when (selectedOption) {
            "Eskiye Yeniye" -> {
                // Listenizi eskiye göre sıralayın
            }
            "Yeniye Eskiye" -> {
                // Listenizi yeniye göre sıralayın
            }
            "A'dan Z'ye" -> {
                // Listenizi A'dan Z'ye sıralayın
            }
            "Z'den A'ya" -> {
                // Listenizi Z'den A'ya sıralayın
            }
        }

        Toast.makeText(this, "Seçilen: $selectedOption", Toast.LENGTH_SHORT).show()
    }














}