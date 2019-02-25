package com.example.mytodoexample.presenters

import android.util.Log
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.domain.interactors.AddTask

class TaskPresenter: TaskContract.Presenter {

    private val TAG = "TaskPresenter"

    private val addTaskInteractor: TaskContract.Interactor<Task> = AddTask()

    override fun addTaskCalled(id: String, title: String) {
        Log.d(TAG, "id: $id \n title: $title")
        addTaskInteractor.execute(Task(title))
    }

}