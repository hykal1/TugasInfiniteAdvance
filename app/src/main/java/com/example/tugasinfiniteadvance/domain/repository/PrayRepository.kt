package com.example.tugasinfiniteadvance.domain.repository

import com.example.tugasinfiniteadvance.data.Entity.PrayEntity
import kotlinx.coroutines.flow.Flow


interface PrayRepository {
    suspend fun upsertPray(prayEntity: PrayEntity)
    fun getPrayById(prayId: Int): Flow<PrayEntity?>
    suspend fun deletePrayById(prayId: Int)
    fun getAllPrays(): Flow<List<PrayEntity>>
}