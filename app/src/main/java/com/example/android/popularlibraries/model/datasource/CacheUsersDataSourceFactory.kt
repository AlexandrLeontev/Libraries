package com.example.android.popularlibraries.model.datasource

object CacheUsersDataSourceFactory {
    fun create(): CacheUsersDataSource = CacheUsersDataSourceImpl()
}