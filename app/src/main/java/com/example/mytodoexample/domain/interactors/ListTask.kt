package com.example.mytodoexample.domain.interactors

import com.example.mytodoexample.contractors.OnResponse
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task

class ListTask(val taskRepository: TaskRepository): TaskContract.Interactor<Unit, List<Task>> {

    override fun execute(param: Unit, onResponse: OnResponse<List<Task>>) {
        taskRepository.list(onResponse)
    }

}