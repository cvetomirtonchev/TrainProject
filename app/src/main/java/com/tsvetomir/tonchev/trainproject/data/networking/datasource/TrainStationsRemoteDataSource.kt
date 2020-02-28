package com.tsvetomir.tonchev.trainproject.data.networking.datasource

import com.tsvetomir.tonchev.trainproject.data.model.remote.response.train.TrainResponse
import com.tsvetomir.tonchev.trainproject.data.model.remote.response.trainstation.TrainStationResponse
import com.tsvetomir.tonchev.trainproject.data.networking.client.ApiResponse
import com.tsvetomir.tonchev.trainproject.data.networking.client.RestCallback
import com.tsvetomir.tonchev.trainproject.data.networking.client.RetrofitClient
import com.tsvetomir.tonchev.trainproject.data.networking.services.TrainService
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.ResponseBody

/**
 * Created by Tsvetomir.Tonchev on 2/25/2020.
 */
class TrainStationsRemoteDataSource {

    private val trainService: TrainService by lazy {
        RetrofitClient.createService(TrainService::class.java)
    }

    suspend fun getTrainStations(): ApiResponse<TrainStationResponse> =
        suspendCancellableCoroutine { continuation ->
            trainService.getAllStations()
                .enqueue(object : RestCallback<TrainStationResponse>(continuation) {})
        }

    suspend fun getAllTrainsForStation(stationCode: String): ApiResponse<TrainResponse> =
        suspendCancellableCoroutine { continuation ->
            trainService.getAllTrainsForStation(stationCode)
                .enqueue(object : RestCallback<TrainResponse>(continuation) {})
        }
}