package com.ntip.deviceinventory.devicelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ntip.deviceinventory.R
import kotlinx.android.synthetic.main.fragment_device_list.*

class DeviceListFragment(): Fragment(){

    private lateinit var deviceListViewModel: DeviceListViewModel
    private lateinit var deviceListAdapter: DeviceListAdapter

    override fun onStart() {
        super.onStart()

        deviceListViewModel = ViewModelProvider(this, DeviceListViewModelFactory(requireActivity().application)).get(DeviceListViewModel::class.java)

        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        deviceListViewModel.deviceList.observe(viewLifecycleOwner, Observer { deviceListAdapter.submitList(it) })
        deviceListAdapter.event.observe(viewLifecycleOwner, Observer { deviceListViewModel.handleEvent(it) })
        deviceListViewModel.deviceItem.observe(viewLifecycleOwner, Observer{Toast.makeText(requireContext(), "Item clicked: $it", Toast.LENGTH_LONG).show()})
    }

    private fun setupAdapter() {
        deviceListAdapter = DeviceListAdapter()
        device_recycler_view.apply{
            adapter = deviceListAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_device_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_device_fab.setOnClickListener {
            Toast.makeText(requireContext(), "Starting acitivity", Toast.LENGTH_LONG).show()
        }
    }
}