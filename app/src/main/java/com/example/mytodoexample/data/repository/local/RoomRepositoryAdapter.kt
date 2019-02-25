package com.example.mytodoexample.data.repository.local

import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task

class RoomRepositoryAdapter : TaskRepository {

    val mapper: RoomRepositoryMapper = RoomRepositoryMapper()

    override fun create(task: Task) {
        val roomTask = mapper.taksToRoomTask(task)

    }

    override fun list() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}