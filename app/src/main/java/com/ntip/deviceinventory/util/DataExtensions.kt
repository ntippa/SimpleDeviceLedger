package com.ntip.deviceinventory.util

import com.ntip.deviceinventory.data.Device
import com.ntip.deviceinventory.data.DeviceRoomEntity

val Device.toDeviceRoomEntity: DeviceRoomEntity
get() = DeviceRoomEntity(
    this.id,
    this.deviceTitle,
    this.osName,
    this.manufacturer,
    this.isCheckedOut,
    this.lastCheckedOutDate,
    this.lastCheckedOutBy
)

fun List<DeviceRoomEntity>.toDeviceList(): List<Device> = this.map{it.toDevice}

val DeviceRoomEntity.toDevice: Device
get()= Device(
    this.id,
    this.deviceTitle,
    this.osName,
    this.manufacturer,
    this.isCheckedOut,
    this.lastCheckedOutDate,
    this.lastCheckedOutBy
)