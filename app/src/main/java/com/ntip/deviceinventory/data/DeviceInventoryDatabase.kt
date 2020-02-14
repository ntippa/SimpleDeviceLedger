package com.ntip.deviceinventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [DeviceRoomEntity::class], version = 1, exportSchema = false)
abstract class DeviceInventoryDatabase(): RoomDatabase() {
    abstract fun deviceDao(): DeviceDao

    companion object {
        private var instance: DeviceInventoryDatabase? = null

        fun getInstance(context: Context): DeviceInventoryDatabase? {
            if (instance == null) {
                synchronized(DeviceInventoryDatabase::class) {
                    //double sure that Database doesnt get created more than once.
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DeviceInventoryDatabase::class.java,
                        "device_inventory_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }

            }
            return instance
        }

        private val roomCallback = object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                initData(instance)

            }
        }

        fun initData(database: DeviceInventoryDatabase?) {
            val deviceDao = database?.deviceDao()
            CoroutineScope(Dispatchers.IO).launch{
                deviceDao?.insertDevice(DeviceRoomEntity(1,"iPhone 6 Plus","iOS 9.3", "Apple", null,null,null))
                deviceDao?.insertDevice(DeviceRoomEntity(2,"test","test", "test", null,null,null))
            }

        }
    }

}
