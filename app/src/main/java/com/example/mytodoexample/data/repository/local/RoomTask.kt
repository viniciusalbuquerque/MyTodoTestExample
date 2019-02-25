package com.example.mytodoexample.data.repository.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "tasks")
data class RoomTask(@ColumnInfo(name = "title") val title: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "taskid")
    var id: Long = 0L
}