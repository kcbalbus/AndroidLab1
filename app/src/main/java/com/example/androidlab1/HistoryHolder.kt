package com.example.androidlab1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryHolder (private val resultHistory: ArrayList<Result>): RecyclerView.Adapter<HistoryHolder.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val result:Result = resultHistory[position]

        holder.textViewHisRes.setText(result.BMI.toString())
        holder.textViewDate.setText(result.timestamp.toString())

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return resultHistory.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
        val textViewHisRes: TextView = itemView.findViewById(R.id.textViewHistoryResult)
    }
}