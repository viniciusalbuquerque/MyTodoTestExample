package com.example.mytodoexample.domain.mappers

import com.example.mytodoexample.data.entities.DataTask
import com.example.mytodoexample.domain.entities.Task

interface EntitiesMapper {

    fun mapToDomain(dataTask: DataTask) : Task
    fun mapToData(task: Task) : DataTask
}