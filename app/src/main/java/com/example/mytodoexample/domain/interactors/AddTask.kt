package com.example.mytodoexample.domain.interactors

import android.util.Log
import com.example.mytodoexample.contractors.OnResponse
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.data.entities.DataTask
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.domain.mappers.EntitiesMapper

class AddTask(val taskRepository: TaskRepository, val mapper: EntitiesMapper) : TaskContract.Interactor<Task, Task> {

    companion object {
        val TAG = "AddTask"
    }

    override fun execute(param: Task, onResponse: OnResponse<Task>) {
        val dataTask = mapper.mapToData(param)
        taskRepository.create(dataTask)
    }

}