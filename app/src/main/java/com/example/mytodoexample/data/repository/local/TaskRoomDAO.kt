package com.example.mytodoexample.data.repository.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TaskRoomDAO {

    @Insert
    fun insert(task: RoomTask)

    @Query("SELECT * FROM tasks")
    fun list() : List<RoomTask>
}