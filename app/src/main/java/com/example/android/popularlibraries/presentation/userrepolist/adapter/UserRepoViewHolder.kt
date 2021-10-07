package com.example.android.popularlibraries.presentation.userrepolist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.popularlibraries.databinding.ViewUserRepoItemBinding
import com.example.android.popularlibraries.ext.click
import com.example.android.popularlibraries.ext.setStartDrawableCircleImageFromUri
import com.example.android.popularlibraries.presentation.GitHubUserRepoViewModel

class UserRepoViewHolder(view: View) : ViewHolder(view) {

    private val viewBinding: ViewUserRepoItemBinding by viewBinding()

    fun bind(user: GitHubUserRepoViewModel, delegate: UserRepoAdapter.Delegate?) {
        with(viewBinding) {
            userLogin.setStartDrawableCircleImageFromUri(user.name)
            userLogin.text = user.name
            root.click { delegate?.onUserPickedRepo(user) }
        }
    }

}