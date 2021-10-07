package com.example.android.popularlibraries.presentation.users.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.android.popularlibraries.presentation.GitHubUserViewModel

object UserDiff : DiffUtil.ItemCallback<GitHubUserViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(
        oldItem: GitHubUserViewModel,
        newItem: GitHubUserViewModel,
    ): Boolean {
        return oldItem.login == newItem.login
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: GitHubUserViewModel,
        newItem: GitHubUserViewModel,
    ): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel) =
        payload

}

