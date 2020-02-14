package com.ntip.deviceinventory.data

import android.app.Application
import com.ntip.deviceinventory.util.toDeviceList
import com.ntip.deviceinventory.util.toDeviceRoomEntity

class DeviceRepository(application: Application): IDeviceRepository{
    private var deviceDao : DeviceDao

    init{
        var database: DeviceInventoryDatabase = DeviceInventoryDatabase.getInstance(application) ?: throw Exception("NO database exception")
        deviceDao = database.deviceDao()
    }

    override suspend fun getDeviceList(): List<Device> = deviceDao.getDeviceList().toDeviceList()

    override suspend fun updateDevice(device: Device) = deviceDao.updateDevice(device.toDeviceRoomEntity)

    override suspend fun deleteDevice(device: Device) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun insertDevice(device: Device) = deviceDao.insertDevice(device.toDeviceRoomEntity)

}