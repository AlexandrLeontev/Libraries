package com.example.android.popularlibraries.data.user.datasource

import com.example.android.popularlibraries.data.room.entities.RoomGithubUser
import io.reactivex.Single

interface CacheUserDataSource : UserDataSource {

    fun retain(users: List<RoomGithubUser>): Single<List<RoomGithubUser>>
    fun retain(user: RoomGithubUser): Single<RoomGithubUser>
}