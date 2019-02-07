package com.example.mytodoexample.ui.listTasks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import com.example.mytodoexample.R
import com.example.mytodoexample.contractors.TaskContract

class ListTasksActivity : AppCompatActivity(), TaskContract.View {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fbAddTask:FloatingActionButton = findViewById(R.id.fb_add_task)
        fbAddTask.setOnClickListener {
            buildAddTaskDialog()
        }
    }

    private fun buildAddTaskDialog() {
        AddTaskDialogFragment()

    }


}
