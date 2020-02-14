package com.ntip.deviceinventory.data

data class Device(
    val id: Int,
    val deviceTitle: String,
    val osName: String,
    val manufacturer: String,
    val isCheckedOut: Boolean?,
    val lastCheckedOutDate: String?,
    val lastCheckedOutBy: String?
)