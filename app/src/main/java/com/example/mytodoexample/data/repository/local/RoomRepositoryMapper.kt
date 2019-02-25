package com.example.mytodoexample.data.repository.local

import com.example.mytodoexample.domain.entities.Task

class RoomRepositoryMapper {

    fun taksToRoomTask(task: Task) : RoomTask {
        return RoomTask(task.title)
    }

    fun roomTaskToTask(roomTask: RoomTask) : Task {
        return Task(roomTask.title)
    }


}