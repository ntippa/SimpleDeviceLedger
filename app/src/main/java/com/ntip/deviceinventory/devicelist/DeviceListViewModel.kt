package com.ntip.deviceinventory.devicelist

import android.app.Application
import androidx.lifecycle.*
import com.ntip.deviceinventory.data.Device
import com.ntip.deviceinventory.data.DeviceDao
import com.ntip.deviceinventory.data.DeviceRepository
import com.ntip.deviceinventory.util.toDeviceList
import kotlinx.coroutines.launch

class DeviceListViewModel(application: Application): AndroidViewModel(application){

    val deviceRepository = DeviceRepository(application)


    private var deviceListstate = MutableLiveData<List<Device>>()
    val deviceList: LiveData<List<Device>> get() = deviceListstate

    init{ getDevices()}

    fun getDevices(): LiveData<List<Device>>{
        viewModelScope.launch {
            val deviceListResult = deviceRepository.getDeviceList()
            deviceListstate.value =  deviceListResult
        }
        return deviceList
    }

    private val deviceItemClickState = MutableLiveData<String>()
    val deviceItem: LiveData<String> get() =  deviceItemClickState

    fun handleEvent(event: DeviceListViewEvent){
        when(event){
            is DeviceListViewEvent.OnDeviceItemClick -> deviceItemClicked(event.position)
        }

    }

    private fun deviceItemClicked(position: Int){
        deviceItemClickState.value = deviceList.value!![position].deviceTitle
    }
}