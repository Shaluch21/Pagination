package com.example.pagination

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val onItemClick: (Post) -> Unit) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    private val dataList: MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val post = dataList[position]
        holder.bind(post)
        holder.itemView.setOnClickListener { onItemClick(post) }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun addData(data: List<Post>) {
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        private val textBody: TextView = itemView.findViewById(R.id.textBody)

        fun bind(post: Post) {
            textTitle.text = "Post ID: ${post.id}"
            textBody.text = post.title
        }
    }
}