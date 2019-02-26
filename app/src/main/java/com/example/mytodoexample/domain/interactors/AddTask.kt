package com.example.mytodoexample.domain.interactors

import android.util.Log
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.data.repository.TaskRepository

class AddTask(val taskRepository: TaskRepository) : TaskContract.Interactor<Task> {

    companion object {
        val TAG = "AddTask"
    }

    override fun execute(task: Task) {
        Log.d(TAG, "Add task interactor for task: ${task.title}")
        taskRepository.create(task)
    }

}