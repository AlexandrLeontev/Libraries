package com.example.android.popularlibraries.presentation.user

import com.example.android.popularlibraries.presentation.GitHubUserViewModel
import com.example.android.popularlibraries.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : ScreenView {

    @SingleState
    fun showUser(user: GitHubUserViewModel)
}