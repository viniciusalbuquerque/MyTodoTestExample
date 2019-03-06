package com.example.mytodoexample.contractors

interface OnResponse<R> {

    fun onSuccess(response: R)
    fun onFail(error: Throwable)

}