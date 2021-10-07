package com.example.android.popularlibraries.data.user.datasource

import com.example.android.popularlibraries.data.api.GitHubApiFactory

object UserDataSourceFactory {

    fun create(): UserDataSource = CloudUserDataSource(GitHubApiFactory.create())
}