package com.tutlemint.assisment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.tutlemint.assisment.R
import com.tutlemint.assisment.models.IssueListItem
import java.text.SimpleDateFormat
import java.util.*

internal class CustomAdapter(private var list: List<IssueListItem>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var staus: TextView = view.findViewById(R.id.status)
        var details: TextView = view.findViewById(R.id.details)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = list[position]
        holder.title.text = listItem.title
        holder.staus.text = listItem.state
        holder.details.text = "#"+listItem.number+" last opened on "+getLastModified(listItem)
    }

    private fun getLastModified(listItem: IssueListItem): Any? {
        val date = "2019-07-14T18:30:00.000Z"
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val outputFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a")
        val parsedDate: Date = inputFormat.parse(date)
        val formattedDate: String = outputFormat.format(parsedDate)
        return formattedDate
    }

    override fun getItemCount(): Int {
        return list.size
    }
}