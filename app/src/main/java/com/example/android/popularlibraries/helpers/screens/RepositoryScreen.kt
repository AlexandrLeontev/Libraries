package com.example.android.popularlibraries.helpers.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.android.popularlibraries.baselogic.userrepositories.RepositoryFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class RepositoryScreen(
    private val userLogin: String,
    private val repositoryName: String,
) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        RepositoryFragment.newInstance(userLogin, repositoryName)
}