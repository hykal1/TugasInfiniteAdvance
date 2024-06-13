package com.example.tugasinfiniteadvance.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.tugasinfiniteadvance.data.Entity.PrayEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PrayDao {

    @Upsert
    suspend fun upsertPray(prayEntity: PrayEntity)

    @Query
        ("SELECT * FROM prays WHERE pray_id = :prayId")
        fun getPrayById(prayId: Int) : Flow<PrayEntity?>

        @Query
            ("DELETE FROM prays WHERE pray_id = :prayId")
        suspend fun deletePrayById(prayId: Int)

        @Query
            ("SELECT * FROM prays")
        fun getAllPrays(): Flow<List<PrayEntity>>
}