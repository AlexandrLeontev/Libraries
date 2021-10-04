package com.example.android.popularlibraries.model.datasource

import com.example.android.popularlibraries.model.api.GithubApiFactory

object UsersDataSourceFactory {
    fun create() = UsersDataSourceImpl(GithubApiFactory.create())
}