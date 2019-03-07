package com.example.mytodoexample.data.repository.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.mytodoexample.data.entities.DataTask


@Entity(tableName = "tasks")
data class RoomTask(@ColumnInfo(name = "title") val title: String): DataTask {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "taskid")
    var id: Long = 0L
}