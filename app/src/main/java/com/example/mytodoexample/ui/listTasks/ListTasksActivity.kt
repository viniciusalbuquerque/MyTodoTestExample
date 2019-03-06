package com.example.mytodoexample.ui.listTasks

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.EditText
import com.example.mytodoexample.R
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.domain.interactors.AddTask
import com.example.mytodoexample.domain.interactors.ListTask
import com.example.mytodoexample.presenters.TaskPresenter
import org.koin.android.ext.android.inject


class ListTasksActivity : AppCompatActivity(), TaskContract.View {

//    private val presenter: TaskContract.Presenter by inject()
    private val repository: TaskRepository by inject()
    private val presenter: TaskContract.Presenter = TaskPresenter(this, ListTask(repository), AddTask(repository))
    private lateinit var rvTasks: RecyclerView
    private lateinit var tasks: MutableList<Task>
    private lateinit var adapter: TaskAdapter


    companion object {
        val TAG = "ListTasksActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tasks = ArrayList()
        configRecyclerView(this.tasks)

        val fbAddTask:FloatingActionButton = findViewById(R.id.fb_add_task)
        fbAddTask.setOnClickListener {
            buildAddTaskDialog()
        }
    }

    private fun configRecyclerView(list: List<Task>) {
        rvTasks = findViewById(R.id.rv_tasks)
        this.adapter = TaskAdapter(list)
        rvTasks.adapter = this.adapter
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
        this.tasks.add(task)
        this.adapter.notifyItemInserted(this.tasks.size - 1)
    }

    override fun listTasks(tasks: List<Task>) {
        Log.d(TAG, "list tasks")
        for(task in tasks) {
            Log.d(TAG, task.title)
        }
        this.tasks.clear()
        this.tasks.addAll(tasks)
        this.adapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.listTasksCalled()
    }

}
