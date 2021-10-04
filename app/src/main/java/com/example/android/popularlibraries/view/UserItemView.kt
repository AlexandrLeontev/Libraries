package com.example.android.popularlibraries.view

interface UserItemView : IItemView {
    fun setUser(login: String, avatar_url: String)
}