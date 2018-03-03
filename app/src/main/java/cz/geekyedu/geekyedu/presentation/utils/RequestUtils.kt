package cz.geekyedu.geekyedu.presentation.utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> Call<T>.setEnqueue(
        onResponse : (call: Call<T>, response: Response<T>) -> Unit,
        onFailure : (call: Call<T>, t: Throwable) -> Unit
){
    enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            onFailure(call, t)
        }

        override fun onResponse(
                call: Call<T>,
                response: Response<T>
        ) {
            onResponse(call, response)
        }
    })
}