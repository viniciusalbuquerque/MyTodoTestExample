package com.example.mytodoexample.ui.listTasks

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.widget.EditText
import com.example.mytodoexample.R
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.presenters.TaskPresenter

class ListTasksActivity : AppCompatActivity(), TaskContract.View {

    val presenter: TaskContract.Presenter = TaskPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fbAddTask:FloatingActionButton = findViewById(R.id.fb_add_task)
        fbAddTask.setOnClickListener {
            buildAddTaskDialog()
        }
    }

    private fun buildAddTaskDialog() {
        val addTaskDialog = AddTaskDialogFragment()
        addTaskDialog.onPositiveOnClickListener = DialogInterface.OnClickListener { _, _ ->
            val text = addTaskDialog.dialog.findViewById<EditText>(R.id.dg_et_title).text.toString()
            presenter.addTaskCalled("ID", text)
        }
        addTaskDialog.show(supportFragmentManager, "")
    }

    override fun taskAdded(task: Task) {

    }

}
