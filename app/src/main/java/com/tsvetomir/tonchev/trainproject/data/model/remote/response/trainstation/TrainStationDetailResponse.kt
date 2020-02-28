package com.tsvetomir.tonchev.trainproject.data.model.remote.response.trainstation

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by Tsvetomir.Tonchev on 2/25/2020.
 */

@Root(name = "objStation")
data class TrainStationDetailResponse (
    @field:Element(name = "StationDesc")
    var stationDesc: String?= "",
    @field:Element(name = "StationAlias",required = false)
    var stationAlias: String?= "",
    @field:Element(name = "StationLatitude")
    var stationLatitude: String?= "",
    @field:Element(name = "StationLongitude")
    var stationLongitude: String?= "",
    @field:Element(name = "StationCode")
    var stationCode: String?= "",
    @field:Element(name = "StationId")
    var stationId: String?= ""
)

