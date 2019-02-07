package com.example.mytodoexample.domain.repository.local

import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.domain.repository.TaskRepository

class LocalTaskRepository : TaskRepository {
    override fun create(task: Task) {
        //USE ROOM
    }

}