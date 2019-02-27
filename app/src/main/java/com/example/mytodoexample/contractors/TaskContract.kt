package com.example.mytodoexample.contractors

import com.example.mytodoexample.domain.entities.Task

interface TaskContract {

    interface View {
        fun taskAdded(task: Task)
        fun listTasks(tasks: List<Task>)
    }

    interface Presenter {
        fun addTaskCalled(title:String)
        fun listTasksCalled()
        fun taskAdded(task: Task)
    }

    interface Interactor<P> {
        fun execute(param: P)
    }

}