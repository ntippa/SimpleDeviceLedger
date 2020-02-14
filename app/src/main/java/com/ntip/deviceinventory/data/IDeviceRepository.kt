package com.ntip.deviceinventory.data

interface IDeviceRepository {
    suspend fun getDeviceList(): List<Device>
    suspend fun updateDevice(device:Device)
    suspend fun deleteDevice(device: Device)
    suspend fun insertDevice(device: Device)
}