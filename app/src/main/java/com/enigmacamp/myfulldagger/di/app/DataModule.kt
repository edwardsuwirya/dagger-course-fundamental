package com.enigmacamp.myfulldagger.di.app

import android.app.Application
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.enigmacamp.myfulldagger.data.SharedPref
import com.enigmacamp.myfulldagger.data.db.AppDatabase
import com.enigmacamp.myfulldagger.data.db.CustomerDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "enigma_database"
        ).build()
    }

    @Provides
    fun provideCustomerDao(db: AppDatabase): CustomerDao {
        return db.customerDao()
    }

    @Provides
    @Singleton
    fun provideSharedPref(application: Application): SharedPref {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val pref = EncryptedSharedPreferences.create(
            "SharedPref",
            masterKeyAlias,
            application,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        return SharedPref(pref)
    }
}