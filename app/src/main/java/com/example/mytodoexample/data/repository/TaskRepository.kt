package com.example.mytodoexample.data.repository

import com.example.mytodoexample.contractors.OnResponse
import com.example.mytodoexample.data.entities.DataTask
import com.example.mytodoexample.domain.entities.Task
import io.reactivex.Flowable

interface TaskRepository {
    fun create(dataTask: DataTask)
    fun list() : Flowable<List<Task>>
}