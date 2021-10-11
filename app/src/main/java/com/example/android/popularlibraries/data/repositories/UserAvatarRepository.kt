package com.example.android.popularlibraries.data.repositories

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.example.android.popularlibraries.data.entity.GithubUser

interface UserAvatarRepository {

    fun imageBuilder(user: GithubUser): RequestBuilder<Drawable>
}