package com.example.android.popularlibraries.model.repo

import com.example.android.popularlibraries.model.datasource.CacheUsersDataSourceFactory
import com.example.android.popularlibraries.model.datasource.UsersDataSourceFactory

object GithubUsersRepoFactory {
    fun create(): IGithubUsersRepo = GithubUsersRepo(
        UsersDataSourceFactory.create(),
        CacheUsersDataSourceFactory.create())
}