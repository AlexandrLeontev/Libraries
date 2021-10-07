package com.example.android.popularlibraries.presentation

import com.example.android.popularlibraries.data.room.entities.RoomGithubRepository

data class GitHubUserRepoViewModel(
    val name: String,
    val description: String,
    val language: String,
    val forks_count: Int,
) {

    object Mapper {

        fun map(user: RoomGithubRepository) =
            GitHubUserRepoViewModel(
                user.name,
                user.description!!,
                user.language,
                user.forks_count
            )
    }
}