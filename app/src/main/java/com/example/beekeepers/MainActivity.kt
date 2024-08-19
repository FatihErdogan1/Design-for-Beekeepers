package com.example.beekeepers

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.beekeepers.adapters.MainpageAdapter
import com.example.beekeepers.data.ItemData
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


    }

}