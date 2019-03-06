package com.example.mytodoexample.presenters

import android.util.Log
import com.example.mytodoexample.contractors.OnResponse
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.domain.interactors.AddTask
import com.example.mytodoexample.domain.interactors.ListTask

class TaskPresenter(val view: TaskContract.View, val listTask: ListTask, val addTaskInteractor: AddTask) : TaskContract.Presenter {

    val TAG = "TaskPresenter"

    override fun addTaskCalled(title: String) {
        Log.d(TAG, "title: $title")
        addTaskInteractor.execute(Task(title), object : OnResponse<Task> {
            override fun onSuccess(response: Task) {
                view.taskAdded(response)
            }

            override fun onFail(error: Throwable) {
                Log.e(TAG, error.message)
            }

        })
    }

    override fun listTasksCalled() {
        Log.d(TAG, "list tasks called")
        listTask.execute(Unit, object : OnResponse<List<Task>> {

            override fun onSuccess(response: List<Task>) {
                view.listTasks(response)
            }

            override fun onFail(error: Throwable) {
                Log.e(TAG, error.message)
            }

        })

    }

    override fun taskAdded(task: Task) {
        view.taskAdded(task)
    }



}