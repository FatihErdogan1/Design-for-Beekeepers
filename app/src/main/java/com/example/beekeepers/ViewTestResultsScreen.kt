package com.example.beekeepers

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.beekeepers.adapters.testadapter
import com.example.beekeepers.data.testData
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




        val test1: testData = testData(
            R.drawable.surveyicon,
            "2024-05-12",
            "150mg",
            "Glikoz Test"
        )
        val test2: testData = testData(
            R.drawable.surveyicon,
            "2024-05-12",
            "150mg",
            "Sugar Test"
        )
        binding.testRecyclerView.adapter = testadapter(listOf(test1, test2))
        binding.testRecyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

        binding.toolbarLayoutTop.imageViewMenu.setOnClickListener {
            val popup = PopupMenu(this, binding.toolbarLayoutTop.imageViewMenu)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.toolbar_menu, popup.menu)
            popup.show()
            popup.setOnMenuItemClickListener { item: MenuItem? ->
                when (item!!.itemId) {
                    R.id.mainMenu -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.scanQRButton -> {
                        val intent = Intent(this, scanBarcodeScreen::class.java)
                        startActivity(intent)
                        true
                    }

                    R.id.logOutButton -> {
                        val intent = Intent(this, loginPage::class.java)
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
            }
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
                Toast.makeText(this@viewTestResultsScreen, "Selected: $selectedOption", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Hiçbir şey seçilmediğinde yapılacak işlemler
            }




        }    // Spinner için seçenekler
        val seasons = arrayOf("2024-Summer", "2024-Autumn", "2024-Winter", "2024-Spring")

        // Adapter oluştur ve Spinner'a ata
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, seasons)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSeasons.adapter = adapter

        // Spinner öğesi tıklandığında yapılacak işlemler
        binding.spinnerSeasons.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedSeason = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@viewTestResultsScreen, "Selected Season: $selectedSeason", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Hiçbir şey seçilmediğinde yapılacak işlemler
            }
        }







    }
    fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        val selectedOption = parent.getItemAtPosition(position).toString()

        when (selectedOption) {
            "Old to New" -> {
                // Listenizi eskiye göre sıralayın
            }
            "New to old" -> {
                // Listenizi yeniye göre sıralayın
            }
            "A-Z" -> {
                // Listenizi A'dan Z'ye sıralayın
            }
            "Z-A" -> {
                // Listenizi Z'den A'ya sıralayın
            }
        }

        Toast.makeText(this, "Selected: $selectedOption", Toast.LENGTH_SHORT).show()
    }














}