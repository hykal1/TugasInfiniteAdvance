package com.example.tugasinfiniteadvance.data.repository

import com.example.tugasinfiniteadvance.data.Entity.PrayEntity
import com.example.tugasinfiniteadvance.data.LocalDataSource
import com.example.tugasinfiniteadvance.data.dao.PrayDao
import com.example.tugasinfiniteadvance.domain.repository.PrayRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrayRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
    ) : PrayRepository {
        override suspend fun upsertPray(prayEntity: PrayEntity) = localDataSource.upsertPray(prayEntity)

        override fun getPrayById(prayId: Int): Flow<PrayEntity?> = localDataSource.getPrayById(prayId)

        override suspend fun deletePrayById(prayId: Int) = localDataSource.deletePrayById(prayId)

        override fun getAllPrays() : Flow<List<PrayEntity>> = localDataSource.getAllPrays()

}