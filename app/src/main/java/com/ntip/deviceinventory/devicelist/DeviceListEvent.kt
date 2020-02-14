package com.ntip.deviceinventory.devicelist


//courtesy: https://github.com/BracketCove/SpaceNotes
sealed class DeviceListViewEvent {
    data class OnDeviceItemClick(val position: Int) : DeviceListViewEvent()
}
