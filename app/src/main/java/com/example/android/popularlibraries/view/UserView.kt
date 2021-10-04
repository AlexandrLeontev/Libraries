package com.example.android.popularlibraries.view

import com.example.android.popularlibraries.model.entity.GithubUserRepo
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : ScreenView {
    fun showUser(user: GithubUserViewModel)
    fun updateRepos()
    fun init()
    fun showRepo(repo: GithubUserRepo)
}