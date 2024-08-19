package com.example.beekeepers

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.beekeepers.databinding.ActivityScanBarcodeScreenBinding

class scanBarcodeScreen : AppCompatActivity() {
    private var _binding: ActivityScanBarcodeScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityScanBarcodeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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