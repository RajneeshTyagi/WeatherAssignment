package com.rajneesh.assignment.model

import com.rajneesh.assignment.EnumFlags
import java.io.Serializable

data class EventBusModel(
    var enum: EnumFlags,
    var obj: Any? = null,
    var flag: Int = 0
) : Serializable
data class Request(var type: String, var query: String, var language: String)
data class Location(
    var name: String,
    var country: String,
    var region: String,
    var lat: String,
    var lon: String,
    var timezone_id: String,
    var localtime: String
)

data class Current(
    var observation_time: String,
    var temperature: Int,
    var weather_code: Int,
    var weather_icons: ArrayList<String>,
    var weather_descriptions: ArrayList<String>,
    var wind_speed: String,
    var wind_degree: Int,
    var wind_dir: Int,
    var pressure: Int,
    var precip: Int,
    var humidity: Int,
    var cloudcover: Int,
    var feelslike: Int,
    var uv_index: Int,
    var visibility: Int,
    var is_day: String
)