package com.tsvetomir.tonchev.trainproject.data.model.remote.response.trainstation

import org.simpleframework.xml.*

/**
 * Created by Tsvetomir.Tonchev on 2/25/2020.
 */

@Root(name = "ArrayOfObjStation")
data class TrainStationResponse constructor(
    @field:ElementList(name = "objStation", inline = true)
    @Path("ArrayOfObjStation")
    var trainStationsList: List<TrainStationDetailResponse> = ArrayList()
)
