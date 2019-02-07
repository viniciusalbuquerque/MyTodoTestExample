package com.example.mytodoexample.domain.repository

import com.example.mytodoexample.domain.entities.Task

interface TaskRepository {
    fun create(task: Task)
}