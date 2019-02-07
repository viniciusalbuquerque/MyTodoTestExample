package com.example.mytodoexample.ui.listTasks

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import com.example.mytodoexample.R
import kotlinx.android.synthetic.main.activity_main.view.*

class AddTaskDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
            .setView(R.layout.abc_action_menu_item_layout).create()
//            .setPositiveButton("Ok", )
    }

}