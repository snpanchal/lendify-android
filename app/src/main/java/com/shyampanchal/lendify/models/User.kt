package com.shyampanchal.lendify.models

import com.squareup.moshi.Json

data class User(
    @Json(name = "email") val email: String,
    @Json(name = "name") val name: String,
    @Json(name = "phone") val phoneNumber: String
)