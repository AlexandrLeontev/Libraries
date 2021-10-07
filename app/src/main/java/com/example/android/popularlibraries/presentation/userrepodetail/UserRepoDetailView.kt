package com.example.android.popularlibraries.presentation.userrepodetail

import com.example.android.popularlibraries.presentation.GitHubUserRepoViewModel
import com.example.android.popularlibraries.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface UserRepoDetailView : ScreenView {
    @SingleState
    fun showForkCount(user: GitHubUserRepoViewModel)
}