package com.example.beekeepers.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.beekeepers.data.ItemData
import com.example.beekeepers.R
import com.example.beekeepers.databinding.ActivityMainBinding

class MainpageAdapter(private val context: Context, private val items: List<ItemData>) : BaseAdapter()
{
   private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    // Adapter for the main page
    // This adapter

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.photo, parent, false)

        val item = items[position]




        // Image ve metinleri ayarla


        // Düzenle ve sil butonları için tıklama işlemleri


        return view
    }


}