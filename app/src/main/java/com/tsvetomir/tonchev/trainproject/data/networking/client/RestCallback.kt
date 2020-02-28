package com.tsvetomir.tonchev.trainproject.data.networking.client

import com.tsvetomir.tonchev.trainproject.data.networking.client.ApiResponse.Companion.STATUS_ERROR
import com.tsvetomir.tonchev.trainproject.data.networking.client.ApiResponse.Companion.STATUS_OK
import kotlinx.coroutines.CancellableContinuation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Created by Tsvetomir.Tonchev on 2/25/2020.
 */
open class RestCallback<T>(private val continuation: CancellableContinuation<ApiResponse<T>>) :
    Callback<T> {

    private val mBaseApiResponse = ApiResponse<T>()

    override fun onResponse(call: Call<T>, response: Response<T>) {
        mBaseApiResponse.httpCode = (response.code())

        if (response.isSuccessful) {
            mBaseApiResponse.responseStatus = STATUS_OK
            mBaseApiResponse.responseData = response.body()
        } else {
            mBaseApiResponse.responseStatus = STATUS_ERROR
            //TODO get error from errorBody
            mBaseApiResponse.error = response.message()
            val errorBody = response.errorBody()?.string()

        }

        continuation.resume(mBaseApiResponse)
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        continuation.resumeWithException(t)
    }
}