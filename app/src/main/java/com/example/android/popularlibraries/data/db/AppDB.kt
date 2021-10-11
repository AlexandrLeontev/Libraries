package com.example.android.popularlibraries.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.popularlibraries.data.db.dao.GithubUserDao
import com.example.android.popularlibraries.data.db.dao.GithubUserRepositoryDao
import com.example.android.popularlibraries.data.entity.GithubUser
import com.example.android.popularlibraries.data.entity.GithubUserRepository

@Database(
    entities = [GithubUser::class, GithubUserRepository::class],
    version = AppDB.DB_VERSION,
    exportSchema = true)
abstract class AppDB : RoomDatabase() {

    abstract fun githubUserDao(): GithubUserDao
    abstract fun githubUserRepositoryDao(): GithubUserRepositoryDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "app.db"

        const val TABLE_USERS = "users"
        const val TABLE_USER_REPOSITORIES = "user_repositories"

        const val USER_ID = "user_id"
        const val LOGIN = "login"
        const val AVATAR_URL = "avatar_url"
        const val REPOSITORY_ID = "repository_id"
        const val NAME = "name"
        const val FULL_NAME = "full_name"
        const val FORKS = "forks"
        const val SIZE = "size"
        const val CREATED = "created"
    }
}