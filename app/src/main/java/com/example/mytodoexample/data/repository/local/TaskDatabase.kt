package com.example.mytodoexample.data.repository.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(RoomTask::class), version = 1)
abstract class TaskDatabase: RoomDatabase() {

    companion object {
        val DB_NAME : String = "tasks-room-database"
        var INSTANCE: TaskDatabase ?= null
    }

    abstract fun taskDao() : RoomRepository


}