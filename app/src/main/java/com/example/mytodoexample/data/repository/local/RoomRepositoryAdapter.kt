package com.example.mytodoexample.data.repository.local

import android.util.Log
import com.example.mytodoexample.contractors.OnResponse
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

    override fun list(onResponse: OnResponse<List<Task>>) {
        Log.d(TAG, "list called")
        taskRoomDAO.list()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({
                Log.d(TAG, "onSuccess")
                onResponse.onSuccess(it.map { mapper.roomTaskToTask(it) })
            }, {
                Log.d(TAG, "onFail")
                onResponse.onFail(it)
            })
        val tasks = taskRoomDAO.list()
        Log.d(TAG, tasks.toString())
    }

}