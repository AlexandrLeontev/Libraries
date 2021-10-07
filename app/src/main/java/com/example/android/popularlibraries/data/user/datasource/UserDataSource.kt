package com.example.android.popularlibraries.data.user.datasource

import com.example.android.popularlibraries.data.room.entities.RoomGithubRepository
import com.example.android.popularlibraries.data.room.entities.RoomGithubUser
import io.reactivex.Maybe
import io.reactivex.Single

interface UserDataSource {

    fun getUsers(): Single<List<RoomGithubUser>>
    fun getUserByLogin(userId: String): Maybe<RoomGithubUser>

    fun getUserListRepo(reposUrl: String): Single<List<RoomGithubRepository>>
}