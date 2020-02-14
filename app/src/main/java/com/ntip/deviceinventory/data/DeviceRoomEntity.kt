package com.ntip.deviceinventory.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="device_table")
data class DeviceRoomEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val deviceTitle: String,
    val osName: String,
    val manufacturer: String,
    val isCheckedOut: Boolean?,
    val lastCheckedOutDate: String?,
    val lastCheckedOutBy: String?
)