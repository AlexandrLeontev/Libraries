package com.example.android.popularlibraries.helpers.di.modules

import com.example.android.popularlibraries.baselogic.main.MainActivity
import com.example.android.popularlibraries.baselogic.user.UserFragment
import com.example.android.popularlibraries.baselogic.userrepositories.RepositoryFragment
import com.example.android.popularlibraries.baselogic.users.UsersFragment
import com.example.android.popularlibraries.convert.ImageCompressorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface UIModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindRepositoryFragment(): RepositoryFragment

    @ContributesAndroidInjector
    fun bindImageCompressorFragment(): ImageCompressorFragment
}