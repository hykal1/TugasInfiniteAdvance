package com.example.tugasinfiniteadvance.data

import com.example.tugasinfiniteadvance.data.Entity.PrayEntity
import com.example.tugasinfiniteadvance.data.room.dao.PrayDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val prayDao: PrayDao)
{
    suspend fun upsertPray(pray: PrayEntity) = prayDao.upsertPray(pray)

    fun getPrayById(prayId: Int) = prayDao.getPrayById(prayId)

    suspend fun deletePrayById(id: Int) = prayDao.deletePrayById(id)

    fun getAllPrays() = prayDao.getAllPrays()

}