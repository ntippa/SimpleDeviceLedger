package com.ntip.deviceinventory.devicelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ntip.deviceinventory.R
import com.ntip.deviceinventory.data.Device
import kotlinx.android.synthetic.main.device_item_layout.view.*

class DeviceListAdapter(val event: MutableLiveData<DeviceListViewEvent> = MutableLiveData()) : ListAdapter< Device, DeviceListAdapter.DeviceItemViewHolder>(deviceModelDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceItemViewHolder =
   DeviceItemViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.device_item_layout, parent, false)
    )

    override fun onBindViewHolder(viewHolder: DeviceItemViewHolder, position: Int) {
        if(viewHolder is DeviceItemViewHolder) viewHolder.bind(getItem(position), position)
    }


    inner class DeviceItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(device: Device, position: Int){
            itemView.title.text = device.deviceTitle
            itemView.description.text = device.osName
            itemView.manufacturer.text = device.manufacturer

            itemView.setOnClickListener {
                event.value = DeviceListViewEvent.OnDeviceItemClick(position)
            }
        }
    }

}

object deviceModelDiffCallback : DiffUtil.ItemCallback<Device>() {
    override fun areItemsTheSame(oldItem: Device, newItem: Device): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Device, newItem: Device): Boolean = oldItem.id == newItem.id
}
