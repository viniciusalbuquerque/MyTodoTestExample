package com.example.mytodoexample.data.repository.local

import android.util.Log
import com.example.mytodoexample.contractors.OnResponse
import com.example.mytodoexample.data.entities.DataTask
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task
import com.example.mytodoexample.domain.mappers.EntitiesMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomRepositoryAdapter(val taskRoomDAO: TaskRoomDAO, val mapper: EntitiesMapper) : TaskRepository {

    companion object {
        val TAG = "RoomRepositoryAdapter"
    }

    override fun create(dataTask: DataTask) {
        val roomTask = dataTask as RoomTask
        taskRoomDAO.insert(roomTask)

    }

    override fun list() : Flowable<List<Task>> {
        Log.d(TAG, "list called")
        return taskRoomDAO.list().map {
            it.map { roomTask -> mapper.mapToDomain(roomTask) }
        }


    }

}