package com.example.android.popularlibraries.helpers.di.modules

import android.content.Context
import androidx.room.Room
import com.example.android.popularlibraries.data.db.AppDB
import com.example.android.popularlibraries.helpers.di.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @AppDataBase
    @Singleton
    @Provides
    fun provideAppDB(context: Context): AppDB =
        Room.databaseBuilder(context, AppDB::class.java, AppDB.DB_NAME)
            .build()

}