package com.example.mytodoexample.domain.interactors

import android.util.Log
import com.example.mytodoexample.contractors.OnResponse
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task

class AddTask(val taskRepository: TaskRepository) : TaskContract.Interactor<Task, Task> {

    companion object {
        val TAG = "AddTask"
    }

    override fun execute(param: Task, onResponse: OnResponse<Task>) {
        Log.d(TAG, "Add task interactor for task: ${param.title}")
        taskRepository.create(param)
    }

}