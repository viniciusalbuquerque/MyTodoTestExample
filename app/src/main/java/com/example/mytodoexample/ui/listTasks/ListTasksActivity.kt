package com.example.mytodoexample.ui.listTasks

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.EditText
import com.example.mytodoexample.R
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.data.repository.local.RoomTask
import com.example.mytodoexample.domain.entities.Task
import org.koin.android.ext.android.inject

class ListTasksActivity : AppCompatActivity(), TaskContract.View {

    val presenter: TaskContract.Presenter by inject()
    internal lateinit var rvTasks: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list:ArrayList<RoomTask> = getList()
        configRecyclerView(list)


        val fbAddTask:FloatingActionButton = findViewById(R.id.fb_add_task)
        fbAddTask.setOnClickListener {
            buildAddTaskDialog()
        }
    }

    private fun getList(): ArrayList<RoomTask> {
        return ArrayList()
    }

    private fun configRecyclerView(list: List<RoomTask>) {
        rvTasks = findViewById(R.id.rv_tasks)
        val tasksAdapter = TaskAdapter(list)
        rvTasks.adapter = tasksAdapter
        rvTasks.layoutManager = LinearLayoutManager(this)

    }

    private fun buildAddTaskDialog() {
        val addTaskDialog = AddTaskDialogFragment()
        addTaskDialog.onPositiveOnClickListener = DialogInterface.OnClickListener { _, _ ->
            val text = addTaskDialog.dialog.findViewById<EditText>(R.id.dg_et_title).text.toString()
            presenter.addTaskCalled(text)
        }
        addTaskDialog.show(supportFragmentManager, "")
    }

    override fun taskAdded(task: Task) {

    }

}
