package com.example.android.popularlibraries.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUserRepo(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("forks") val forkCount: Int,
) : Parcelable
