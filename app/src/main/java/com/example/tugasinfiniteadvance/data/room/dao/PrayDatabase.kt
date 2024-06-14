package com.example.tugasinfiniteadvance.data.room.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tugasinfiniteadvance.data.Entity.PrayEntity

@Database(entities = [PrayEntity::class], version = 2, exportSchema = false)
abstract class PrayDatabase : RoomDatabase() {

    abstract fun prayDao(): PrayDao

}