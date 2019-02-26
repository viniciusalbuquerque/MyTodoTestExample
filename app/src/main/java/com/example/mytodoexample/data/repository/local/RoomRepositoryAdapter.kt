package com.example.mytodoexample.data.repository.local

import android.util.Log
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task

class RoomRepositoryAdapter(val taskRoomDAO: TaskRoomDAO) : TaskRepository {

    companion object {
        val TAG = "RoomRepositoryAdapter"
    }

    val mapper: RoomRepositoryMapper = RoomRepositoryMapper()

    override fun create(task: Task) {
        Log.d(TAG, "create task: ${task.title}")
        val roomTask = mapper.taksToRoomTask(task)
        taskRoomDAO.insert(roomTask)

    }

    override fun list() {
        val tasks = taskRoomDAO.list()
        Log.d(TAG, tasks.toString())
    }

}