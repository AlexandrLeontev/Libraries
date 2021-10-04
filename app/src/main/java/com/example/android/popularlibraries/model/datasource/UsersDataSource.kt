package com.example.android.popularlibraries.model.datasource

import com.example.android.popularlibraries.model.entity.GithubUser
import com.example.android.popularlibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface UsersDataSource {

    fun getUsers(): Single<List<GithubUser>>
    fun getUserByLogin(login: String?): Maybe<GithubUser>
    fun getUserRepos(url: String): Maybe<List<GithubUserRepo>>

}