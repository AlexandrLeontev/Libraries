package com.example.android.popularlibraries.data.user

import com.example.android.popularlibraries.data.user.datasource.CacheUserDataSourceFactory
import com.example.android.popularlibraries.data.user.datasource.UserDataSourceFactory

object GitHubUserRepositoryFactory {

    private val repository: GitHubUserRepository by lazy {
        GitHubUserRepositoryImpl(
            UserDataSourceFactory.create(),
            CacheUserDataSourceFactory.create()
        )
    }

    fun create(): GitHubUserRepository = repository
}