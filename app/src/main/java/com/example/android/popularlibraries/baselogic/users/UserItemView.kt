package com.example.android.popularlibraries.baselogic.users

import com.example.android.popularlibraries.data.entity.GithubUser

interface UserItemView {
    var currentPosition: Int

    fun setLogin(text: String)

    fun setAvatar(user: GithubUser)
}