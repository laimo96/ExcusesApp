package com.example.excusesapp.model


import com.google.gson.annotations.SerializedName

data class Excuses(
    @SerializedName("category")
    val category: String?,
    @SerializedName("excuse")
    val excuse: String?,
    @SerializedName("id")
    val id: Int?
)