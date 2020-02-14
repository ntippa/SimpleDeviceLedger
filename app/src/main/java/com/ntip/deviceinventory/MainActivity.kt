package com.ntip.deviceinventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ntip.deviceinventory.devicelist.DeviceListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deviceListFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(deviceListFragment == null){
            val fragment = DeviceListFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}
