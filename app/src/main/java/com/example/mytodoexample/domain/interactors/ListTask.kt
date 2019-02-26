package com.example.mytodoexample.domain.interactors

import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.data.repository.TaskRepository

class ListTask(val taskRepository: TaskRepository): TaskContract.Interactor<Unit> {

    override fun execute(param: Unit) {
        taskRepository.list()
    }

}