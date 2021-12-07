package com.example.newspaper.DTO

data class WeatherData(
    val response: ResponseData,
)

data class ResponseData(
    val body: BodyData
)

data class BodyData(
    val items: ItemsData
)

data class ItemsData(
    val item: ArrayList<ItemData>
)

data class ItemData(
    val stnNm: String
)