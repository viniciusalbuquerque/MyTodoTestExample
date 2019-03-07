package com.example.mytodoexample.domain.interactors

import com.example.mytodoexample.contractors.OnResponse
import com.example.mytodoexample.contractors.TaskContract
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.domain.entities.Task
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListTask(val taskRepository: TaskRepository): TaskContract.Interactor<Unit, List<Task>> {

    override fun execute(param: Unit, onResponse: OnResponse<List<Task>>) {
        taskRepository.list()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({
                onResponse.onSuccess(it)
            }, {
                onResponse.onFail(it)
            })
    }

}