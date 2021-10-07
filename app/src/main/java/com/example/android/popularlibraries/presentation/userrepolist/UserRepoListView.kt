package com.example.android.popularlibraries.presentation.userrepolist

import com.example.android.popularlibraries.presentation.GitHubUserRepoViewModel
import com.example.android.popularlibraries.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface UserRepoListView : ScreenView {

    @SingleState
    fun showUserRepo(user: List<GitHubUserRepoViewModel>)

}