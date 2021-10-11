package com.example.android.popularlibraries.data.db.cache

import com.example.android.popularlibraries.data.entity.GithubUser
import com.example.android.popularlibraries.data.entity.GithubUserRepository
import io.reactivex.rxjava3.core.Single

interface GithubCache {

    fun insertUsers(users: List<GithubUser>)

    fun getUsers(): Single<List<GithubUser>>

    fun getUser(userLogin: String): Single<GithubUser>

    fun insertRepository(repository: GithubUserRepository)

    fun insertRepositories(repositories: List<GithubUserRepository>)

    fun getRepositoriesOnUserLogin(userLogin: String): Single<List<GithubUserRepository>>

    fun getRepositoryOnUserLogin(
        userLogin: String,
        repositoryName: String,
    ): Single<GithubUserRepository>
}