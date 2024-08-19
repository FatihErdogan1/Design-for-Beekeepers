package com.example.beekeepers.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beekeepers.R
import com.example.beekeepers.data.testData

class testadapter(private val testResults: List<testData>) :
    RecyclerView.Adapter<testadapter.TestResultViewHolder>() {

    class TestResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val timestampTextView: TextView = view.findViewById(R.id.timestampTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.test_result, parent, false)
        return TestResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestResultViewHolder, position: Int) {
        val testResult = testResults[position]
        holder.titleTextView.text = testResult.title
        holder.descriptionTextView.text = testResult.description
        holder.timestampTextView.text = testResult.date
    }

    override fun getItemCount(): Int {
        return testResults.size
    }
}