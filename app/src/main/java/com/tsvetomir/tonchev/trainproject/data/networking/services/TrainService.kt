package com.tsvetomir.tonchev.trainproject.data.networking.services

import com.tsvetomir.tonchev.trainproject.data.model.remote.response.train.TrainResponse
import com.tsvetomir.tonchev.trainproject.data.model.remote.response.trainstation.TrainStationResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Tsvetomir.Tonchev on 2/25/2020.
 */
interface TrainService {

    @GET(GET_ALL_TRAIN_STATIONS_PATH)
    fun getAllStations(): Call<TrainStationResponse>

    @GET(GET_TRAINS_FOR_STATION)
    fun getAllTrainsForStation(@Query("StationCode") stationCode: String): Call<TrainResponse>

    companion object {
        const val GET_ALL_TRAIN_STATIONS_PATH = "getAllStationsXML"
        const val GET_TRAINS_FOR_STATION = "getStationDataByCodeXML"
    }
}