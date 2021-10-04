package com.example.android.popularlibraries.model.datasource

import com.example.android.popularlibraries.model.api.GithubApi
import com.example.android.popularlibraries.model.entity.GithubUser
import com.example.android.popularlibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class UsersDataSourceImpl(private val githubApi: GithubApi) : UsersDataSource {
    override fun getUsers(): Single<List<GithubUser>> = githubApi.getUsers()

    override fun getUserByLogin(login: String?): Maybe<GithubUser> {
        return if (login != null) {
            githubApi.getUserByLogin(login)
                .toMaybe()
        } else {
            Maybe.empty()
        }


    }

    override fun getUserRepos(url: String): Maybe<List<GithubUserRepo>> =
        githubApi.getUserRepos(url).toMaybe()

}
