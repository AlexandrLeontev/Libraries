package com.example.android.popularlibraries.model.repo

import com.example.android.popularlibraries.model.datasource.CacheUsersDataSource
import com.example.android.popularlibraries.model.datasource.UsersDataSource
import com.example.android.popularlibraries.model.entity.GithubUser
import com.example.android.popularlibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubUsersRepo(
    private val usersDataSource: UsersDataSource,
    private val cacheUsersDataSource: CacheUsersDataSource,
) : IGithubUsersRepo {

    override fun getUsers(): Observable<List<GithubUser>> =
        Observable.concat(
            cacheUsersDataSource.getUsers().toObservable(),
            usersDataSource.getUsers().flatMap(cacheUsersDataSource::retain).toObservable()
        ).subscribeOn(Schedulers.io())

    override fun getUserByLogin(login: String?): Maybe<GithubUser> =
        cacheUsersDataSource.getUserByLogin(login)
            .switchIfEmpty(usersDataSource.getUserByLogin(login))
            .subscribeOn(Schedulers.io())

    override fun getUserRepos(url: String): Maybe<List<GithubUserRepo>> =
        usersDataSource.getUserRepos(url)
}