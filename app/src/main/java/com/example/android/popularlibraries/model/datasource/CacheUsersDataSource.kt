package com.example.android.popularlibraries.model.datasource

import com.example.android.popularlibraries.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface CacheUsersDataSource : UsersDataSource {
    fun retain(users: List<GithubUser>): Single<List<GithubUser>>
    fun retain(user: GithubUser): Single<GithubUser>
}