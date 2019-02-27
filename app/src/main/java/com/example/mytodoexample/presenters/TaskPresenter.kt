package com.example.mytodoexample.presenters

import android.util.Log
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.domain.interactors.AddTask
import com.example.mytodoexample.domain.interactors.ListTask

class TaskPresenter(val view: TaskContract.View, val listTask: ListTask, val addTaskInteractor: AddTask) : TaskContract.Presenter {

    val TAG = "TaskPresenter"

    override fun addTaskCalled(title: String) {
        Log.d(TAG, "title: $title")
        addTaskInteractor.execute(Task(title))
    }

    override fun listTasksCalled() {
        listTask.execute(Unit)
    }

    override fun taskAdded(task: Task) {
        view.taskAdded(task)
    }



}