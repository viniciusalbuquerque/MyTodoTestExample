package com.example.mytodoexample.data.repository.local

import com.example.mytodoexample.data.entities.DataTask
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.domain.mappers.EntitiesMapper

class RoomRepositoryMapper : EntitiesMapper {

    override fun mapToDomain(dataTask: DataTask): Task {
        val roomTask = dataTask as RoomTask
        return Task(roomTask.title)
    }

    override fun mapToData(task: Task): RoomTask {
        return RoomTask(task.title)
    }

}