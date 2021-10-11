package com.example.android.popularlibraries.helpers.di.modules

import com.example.android.popularlibraries.convert.ImageConverter
import com.example.android.popularlibraries.convert.ImageConverterImpl
import com.example.android.popularlibraries.data.db.cache.GithubCache
import com.example.android.popularlibraries.data.db.cache.GithubCacheImpl
import com.example.android.popularlibraries.data.repositories.GithubUsersRepository
import com.example.android.popularlibraries.data.repositories.GithubUsersRepositoryImpl
import com.example.android.popularlibraries.data.repositories.UserAvatarRepository
import com.example.android.popularlibraries.data.repositories.UserAvatarRepositoryImpl
import com.example.android.popularlibraries.helpers.NetworkStatus
import com.example.android.popularlibraries.helpers.NetworkStatusImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface UserModule {

    @Singleton
    @Binds
    fun bindGithubUsersRepository(repository: GithubUsersRepositoryImpl): GithubUsersRepository

    @Singleton
    @Binds
    fun bindGithubCache(githubCache: GithubCacheImpl): GithubCache

    @Singleton
    @Binds
    fun bindNetworkStatus(networkStatus: NetworkStatusImpl): NetworkStatus

    @Binds
    fun bindImageConverter(imageConverter: ImageConverterImpl): ImageConverter

    @Singleton
    @Binds
    fun bindUserAvatarRepository(userAvatarRepository: UserAvatarRepositoryImpl): UserAvatarRepository

}