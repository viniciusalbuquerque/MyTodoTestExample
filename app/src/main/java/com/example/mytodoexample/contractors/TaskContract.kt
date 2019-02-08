package com.example.mytodoexample.contractors

interface TaskContract {

    interface View {

    }

    interface Presenter {
        fun addTaskCalled(id: String, title:String)
    }

    interface Interactor {

    }

}