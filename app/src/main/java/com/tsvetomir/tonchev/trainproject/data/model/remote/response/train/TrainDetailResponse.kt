package com.tsvetomir.tonchev.trainproject.data.model.remote.response.train

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by Tsvetomir.Tonchev on 2/28/2020.
 */
@Root(name = "objStationData")
data class TrainDetailResponse(
    @field:Element(name = "Servertime")
    var serveTime: String? = "",
    @field:Element(name = "Traincode")
    var trainCode: String? = "",
    @field:Element(name = "Stationfullname")
    var stationFullName: String? = "",
    @field:Element(name = "Stationcode")
    var stationCode: String? = "",
    @field:Element(name = "Querytime")
    var queryTime: String? = "",
    @field:Element(name = "Traindate")
    var trainDate: String? = "",
    @field:Element(name = "Origin")
    var orgin: String? = "",
    @field:Element(name = "Destination")
    var destination: String? = "",
    @field:Element(name = "Origintime")
    var originTime: String? = "",
    @field:Element(name = "Destinationtime")
    var destinationTime: String? = "",
    @field:Element(name = "Status")
    var status: String = "",
    @field:Element(name = "Lastlocation", required = false)
    var lastLocation: String? = "",
    @field:Element(name = "Duein")
    var duein: String? = "",
    @field:Element(name = "Late")
    var late: String? = "",
    @field:Element(name = "Exparrival")
    var expectArrival: String? = "",
    @field:Element(name = "Expdepart")
    var expDepart: String? = "",
    @field:Element(name = "Scharrival")
    var schArrival: String? = "",
    @field:Element(name = "Schdepart")
    var schDepart: String? = "",
    @field:Element(name = "Direction")
    var direction: String? = "",
    @field:Element(name = "Traintype")
    var trainType: String? = "",
    @field:Element(name = "Locationtype")
    var locationType: String? = ""
)