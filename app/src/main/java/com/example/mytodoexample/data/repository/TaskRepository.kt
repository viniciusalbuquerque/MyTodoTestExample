package com.example.mytodoexample.data.repository

import com.example.mytodoexample.domain.entities.Task

interface TaskRepository {
    fun create(task: Task)
    fun list()
}