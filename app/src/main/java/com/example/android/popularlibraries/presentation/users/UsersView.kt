package com.example.android.popularlibraries.presentation.users

import com.example.android.popularlibraries.presentation.GitHubUserViewModel
import com.example.android.popularlibraries.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : ScreenView {

    /**
     * Показывает список пользователей.
     * @param users список пользователей
     */
    @SingleState
    fun showUsers(users: List<GitHubUserViewModel>)
}