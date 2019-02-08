package com.example.mytodoexample.presenters

import android.util.Log
import com.example.mytodoexample.contractors.TaskContract

class TaskPresenter: TaskContract.Presenter {

    private val TAG = "TaskPresenter"

    override fun addTaskCalled(id: String, title: String) {
        Log.d(TAG, "id: $id \n title: $title")
    }

}