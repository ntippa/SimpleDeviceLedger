package com.ntip.deviceinventory.data

import androidx.room.*

@Dao
interface DeviceDao{
    @Query("SELECT * FROM device_table")
    suspend fun getDeviceList() : List<DeviceRoomEntity>

    @Insert
    suspend fun insertDevice(device: DeviceRoomEntity)

    @Update
    suspend fun updateDevice(device: DeviceRoomEntity)

    @Delete
    suspend fun deleteDevice(device: DeviceRoomEntity)
}