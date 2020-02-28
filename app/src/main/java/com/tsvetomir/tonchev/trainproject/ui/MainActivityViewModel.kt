package com.tsvetomir.tonchev.trainproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsvetomir.tonchev.trainproject.data.model.local.TrainView
import com.tsvetomir.tonchev.trainproject.data.model.remote.response.train.TrainDetailResponse
import com.tsvetomir.tonchev.trainproject.data.repository.TrainStationRepository
import com.tsvetomir.tonchev.trainproject.data.repository.TrainStationRepository.ARKLOW_NAME
import com.tsvetomir.tonchev.trainproject.data.repository.TrainStationRepository.SHANKILL
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Tsvetomir.Tonchev on 2/25/2020.
 */
class MainActivityViewModel : ViewModel() {

    private var mArklowLiveData = MutableLiveData<List<TrainView>>()
    private var mShankillLiveData = MutableLiveData<List<TrainView>>()

    val arklowLiveData: LiveData<List<TrainView>> = mArklowLiveData
    val shankillLiveData: LiveData<List<TrainView>> = mShankillLiveData

    fun getAllTrains() {
        viewModelScope.launch {
            TrainStationRepository.getTrains().collect {
                if (it) {
                    TrainStationRepository.getTrainsForStation(ARKLOW_NAME).collect { result ->
                        mArklowLiveData.value =
                            result?.trainStationsList?.map { trainDetailResponse ->
                                transformToView(trainDetailResponse)
                            }
                    }
                    TrainStationRepository.getTrainsForStation(SHANKILL).collect { result ->
                        mShankillLiveData.value =
                            result?.trainStationsList?.map { trainDetailResponse ->
                                transformToView(trainDetailResponse)
                            }
                    }

                }
            }
        }
    }

    private fun transformToView(accountResponse: TrainDetailResponse): TrainView {
        return TrainView(
            trainType = accountResponse.trainType,
            expetArrival = accountResponse.expectArrival,
            destination = accountResponse.destination
        )
    }
}