package com.tsvetomir.tonchev.trainproject.data.repository

import com.tsvetomir.tonchev.trainproject.data.model.remote.response.train.TrainResponse
import com.tsvetomir.tonchev.trainproject.data.model.remote.response.trainstation.TrainStationDetailResponse
import com.tsvetomir.tonchev.trainproject.data.networking.datasource.TrainStationsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Tsvetomir.Tonchev on 2/25/2020.
 */
object TrainStationRepository {
     const val ARKLOW_NAME = "Arklow"
     const val SHANKILL = "Shankill"

    private val mDataSource = TrainStationsRemoteDataSource()

    private var mArklowStation: TrainStationDetailResponse? = null
    private var mShankillStation: TrainStationDetailResponse? = null

    private val mTrainStations: ArrayList<TrainStationDetailResponse> = ArrayList()

    fun getTrains(): Flow<Boolean> {
        return flow {
            val apiResponse = mDataSource.getTrainStations()
            if (apiResponse.responseStatus == 200) {
                apiResponse.responseData?.let {
                    setTrainStations(it.trainStationsList)
                    emit(true)
                }
            }
        }
    }

    fun getTrainsForStation(station: String): Flow<TrainResponse?> {
        return flow {
            val stationCode = getTrainStationCode(station)
            val apiResponse = mDataSource.getAllTrainsForStation(stationCode)
            if (apiResponse.responseStatus == 200) {
                apiResponse.responseData?.let {
                    emit(apiResponse.responseData)
                }
            }
        }
    }


    private fun setTrainStations(list: List<TrainStationDetailResponse>) {
        for (item in list) {
            if (mTrainStations.size == 2) {
                break
            }
            if (item.stationDesc.equals(ARKLOW_NAME) || item.stationDesc.equals(SHANKILL)) {
                mTrainStations.add(item)
            }
        }
    }

    private fun getTrainStationCode(stationName: String): String {
        var station = ""
        for (item in mTrainStations) {
            if (item.stationDesc.equals(stationName)) {
                item.stationCode?.let {
                    station = it
                }
            }
        }
        return station
    }

}