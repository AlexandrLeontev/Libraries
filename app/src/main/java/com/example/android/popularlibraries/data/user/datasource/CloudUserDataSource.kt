package com.example.android.popularlibraries.data.user.datasource

import com.example.android.popularlibraries.data.api.GitHubApi
import com.example.android.popularlibraries.data.room.entities.RoomGithubUser
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CloudUserDataSource(private val gitHubApi: GitHubApi) : UserDataSource {

    override fun getUsers(): Single<List<RoomGithubUser>> =
        gitHubApi.getUsers()

    override fun getUserByLogin(userId: String): Maybe<RoomGithubUser> =
        gitHubApi.getUserByLogin(userId)
            .toMaybe()

    override fun getUserListRepo(reposUrl: String) =
        gitHubApi.getUserListRepo(reposUrl).subscribeOn(Schedulers.io())

}