package com.example.android.popularlibraries.presentation.userrepodetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserRepoDetailScreen(private val forkCount: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        UserRepoDetailFragment.newInstance(forkCount)
}