package com.example.android.popularlibraries.presentation.userrepolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.android.popularlibraries.R.layout.view_user_repo_item
import com.example.android.popularlibraries.presentation.GitHubUserRepoViewModel

class UserRepoAdapter(private val delegate: Delegate?) :
    ListAdapter<GitHubUserRepoViewModel, UserRepoViewHolder>(UserDiff) {

    interface Delegate {

        /**
         * Событие наступает при выборе
         * пользователя из списка.
         * @param user пользователь
         */
        fun onUserPickedRepo(userRepo: GitHubUserRepoViewModel)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRepoViewHolder =
        UserRepoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(view_user_repo_item, parent, false)
        )

    override fun onBindViewHolder(holder: UserRepoViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

}