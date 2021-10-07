package com.example.android.popularlibraries.data.user.datasource

import com.example.android.popularlibraries.App
import com.example.android.popularlibraries.data.room.GitHubStorageFactory

object CacheUserDataSourceFactory {

    fun create(): CacheUserDataSource =
        CacheUserDataSourceImpl(
            GitHubStorageFactory.create(App.ContextHolder.context)
        )
}