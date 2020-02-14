package com.ntip.deviceinventory.devicelist

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ntip.deviceinventory.data.DeviceInventoryDatabase

class DeviceListViewModelFactory(val application: Application) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return DeviceListViewModel(application) as T
    }

}