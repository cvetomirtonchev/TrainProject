package com.tsvetomir.tonchev.trainproject.data.model.remote.response.train

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import retrofit2.http.Path

/**
 * Created by Tsvetomir.Tonchev on 2/28/2020.
 */
@Root(name = "ArrayOfObjStationData")
data class TrainResponse constructor(
    @field:ElementList(name = "objStationData", inline = true, required = false)
    @Path("ArrayOfObjStationData")
    var trainStationsList: List<TrainDetailResponse> = ArrayList()
)