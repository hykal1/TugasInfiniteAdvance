package com.example.tugasinfiniteadvance.dependencyinjection

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.tugasinfiniteadvance.data.dao.PrayDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PrayDatabase {
        return Room.databaseBuilder(
            context,
            PrayDatabase::class.java,
                "db_pray"
        ).fallbackToDestructiveMigration().build()
    }
    @Provides
    @Singleton
    fun providePrayDao(prayDatabase: PrayDatabase) = prayDatabase.prayDao()
}

// NOTE :
// Room dan databse belum ada jadi belum bisa injection
// Menggunakan database sementara untuk melanjutkan injecttion, tapi database fix belum ada.