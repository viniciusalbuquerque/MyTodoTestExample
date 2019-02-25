package com.example.mytodoexample.domain.interactors

import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.data.repository.TaskRepository

class ListTask: TaskContract.Interactor<Void> {

    var taskRepository :TaskRepository ?= null

    override fun execute(param: Void) {
        taskRepository?.list()
    }

}