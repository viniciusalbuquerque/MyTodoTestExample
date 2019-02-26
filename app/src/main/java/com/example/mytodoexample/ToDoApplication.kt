package com.example.mytodoexample

import android.app.Application
import android.arch.persistence.room.Room
import com.example.mytodoexample.data.repository.TaskRepository
import com.example.mytodoexample.data.repository.local.RoomRepositoryAdapter
import com.example.mytodoexample.data.repository.local.TaskDatabase
import com.example.mytodoexample.domain.interactors.AddTask
import com.example.mytodoexample.domain.interactors.ListTask
import com.example.mytodoexample.presenters.TaskPresenter
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class ToDoApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        val localRepoModule = module {
//            single<TaskRepository> {
//                get() as RoomRepositoryAdapter
//            }
//            single { Room.databaseBuilder(applicationContext,
//                TaskDatabase::class.java, TaskDatabase.DB_NAME)
//                .build() }
            single( definition = { Room.databaseBuilder(applicationContext, TaskDatabase::class.java,
                TaskDatabase.DB_NAME).build()})

            single { get<TaskDatabase>().taskDao() }

            single( definition = { RoomRepositoryAdapter(get()) as TaskRepository })

        }

        val interactorsModule = module {
            factory { AddTask(get()) }
            factory { ListTask(get()) }
        }

        val presenterModule = module {
            single { TaskPresenter(get(), get()) }
        }

        startKoin(this, listOf(localRepoModule, interactorsModule, presenterModule))


    }

}