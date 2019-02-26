package com.example.mytodoexample.data.repository.local

import android.util.Log
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task

class RoomRepositoryAdapter(val roomRepository: RoomRepository) : TaskRepository {

    companion object {
        val TAG = "RoomRepositoryAdapter"
    }

    val mapper: RoomRepositoryMapper = RoomRepositoryMapper()

    override fun create(task: Task) {
        Log.d(TAG, "create task: ${task.title}")
        val roomTask = mapper.taksToRoomTask(task)
        roomRepository.insert(roomTask)

    }

    override fun list() {
        val tasks = roomRepository.list()
        Log.d(TAG, tasks.toString())
    }

}