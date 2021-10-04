package com.example.android.popularlibraries.model.repo

import com.example.android.popularlibraries.model.entity.GithubUser
import com.example.android.popularlibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

interface IGithubUsersRepo {
    fun getUsers(): Observable<List<GithubUser>>
    fun getUserByLogin(login: String?): Maybe<GithubUser>
    fun getUserRepos(url: String): Maybe<List<GithubUserRepo>>
}