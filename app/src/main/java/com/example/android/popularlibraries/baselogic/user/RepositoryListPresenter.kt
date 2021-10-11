package com.example.android.popularlibraries.baselogic.user

import com.example.android.popularlibraries.baselogic.ListPresenter
import com.example.android.popularlibraries.baselogic.userrepositories.RepositoryItemView
import com.example.android.popularlibraries.data.entity.GithubUserRepository

class RepositoryListPresenter : ListPresenter<RepositoryItemView> {
    val repositories = mutableListOf<GithubUserRepository>()

    override var itemClickListener: ((RepositoryItemView) -> Unit)? = null

    override fun getCount() = repositories.size

    override fun bindView(view: RepositoryItemView) {
        val repository = repositories[view.currentPosition]
        view.setName(repository.fullName)
    }
}