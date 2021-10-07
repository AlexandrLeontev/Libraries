package com.example.android.popularlibraries.presentation

import com.example.android.popularlibraries.data.room.entities.RoomGithubUser

data class GitHubUserViewModel(
    val login: String,
    val avatar: String,
    val repos_url: String,
) {

    object Mapper {

        fun map(user: RoomGithubUser) =
            GitHubUserViewModel(
                user.login,
                user.avatar,
                user.repos_url
            )
    }
}