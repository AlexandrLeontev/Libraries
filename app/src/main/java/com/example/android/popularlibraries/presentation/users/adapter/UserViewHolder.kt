package com.example.android.popularlibraries.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.popularlibraries.databinding.ViewUserBinding
import com.example.android.popularlibraries.ext.click
import com.example.android.popularlibraries.ext.setStartDrawableCircleImageFromUri
import com.example.android.popularlibraries.presentation.GitHubUserViewModel

class UserViewHolder(view: View) : ViewHolder(view) {

    private val viewBinding: ViewUserBinding by viewBinding()

    fun bind(user: GitHubUserViewModel, delegate: UsersAdapter.Delegate?) {
        with(viewBinding) {
            userLogin.setStartDrawableCircleImageFromUri(user.avatar)
            userLogin.text = user.login

            root.click { delegate?.onUserPicked(user) }
        }
    }
}