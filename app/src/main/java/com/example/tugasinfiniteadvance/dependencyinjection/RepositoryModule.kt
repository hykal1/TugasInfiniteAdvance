package com.example.tugasinfiniteadvance.dependencyinjection

import com.example.tugasinfiniteadvance.data.repository.PrayRepositoryImpl
import com.example.tugasinfiniteadvance.domain.repository.PrayRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
abstract fun providePrayRepository(prayRepositoryImpl: PrayRepositoryImpl): PrayRepository
}