package com.example.mytodoexample.contractors

import com.example.mytodoexample.domain.entities.Task

interface TaskContract {

    interface View {
        fun taskAdded(task: Task)
    }

    interface Presenter {
        fun addTaskCalled(id: String, title:String)
    }

    interface Interactor<P> {
        fun execute(param: P)
    }

}