package com.example.mytodoexample.ui.listTasks

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytodoexample.R
import kotlinx.android.synthetic.main.activity_main.view.*

class AddTaskDialogFragment: DialogFragment() {

    var onPositiveOnClickListener: DialogInterface.OnClickListener ?= null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
            .setView(R.layout.task_dialog)
            .setTitle("Define a title for your task")
            .setPositiveButton("Ok", onPositiveOnClickListener)
            .setNeutralButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }.create()
    }

}