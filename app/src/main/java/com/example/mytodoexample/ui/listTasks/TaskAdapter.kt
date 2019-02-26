package com.example.mytodoexample.ui.listTasks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mytodoexample.R
import com.example.mytodoexample.domain.entities.Task

class TaskAdapter(val tasks: List<Task>): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task,
            parent, false))
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hTextViewTitle.text = tasks[position].title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hTextViewTitle: TextView = itemView.findViewById(R.id.tv_task)
    }

}