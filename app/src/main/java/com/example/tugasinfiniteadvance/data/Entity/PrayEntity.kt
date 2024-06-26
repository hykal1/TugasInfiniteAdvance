package com.example.tugasinfiniteadvance.data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prays")
data class PrayEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pray_id")
    var id: Int,

    @ColumnInfo(name = "pray_name")
    var prayName: String,
)
