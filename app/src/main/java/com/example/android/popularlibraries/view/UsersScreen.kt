package com.example.android.popularlibraries.view

import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen {
    fun create() = FragmentScreen { UsersFragment.newInstance() }
}