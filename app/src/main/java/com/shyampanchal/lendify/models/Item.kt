package com.shyampanchal.lendify.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "name") val itemName: String,
    @Json(name = "startTime") val startTime: Long, // unix timestamp for start of availability
    @Json(name = "endTime") val endTime: Long // unix timestamp for end of availability
)