package com.example.android.popularlibraries.baselogic.userrepositories

interface RepositoryItemView {
    var currentPosition: Int

    fun setName(text: String)
}