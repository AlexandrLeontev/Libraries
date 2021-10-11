package com.example.android.popularlibraries.helpers.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.android.popularlibraries.convert.ImageCompressorFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ImageCompressorScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        ImageCompressorFragment.newInstance()
}