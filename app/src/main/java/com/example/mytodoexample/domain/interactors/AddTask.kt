package com.example.mytodoexample.domain.interactors

import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.data.repository.TaskRepository

class AddTask: TaskContract.Interactor<Task> {

    var taskRepository:TaskRepository ?= null

    override fun execute(task: Task) {
        taskRepository?.create(task)
    }

}