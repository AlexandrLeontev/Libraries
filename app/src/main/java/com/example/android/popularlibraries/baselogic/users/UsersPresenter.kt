package com.example.android.popularlibraries.baselogic.users

import com.example.android.popularlibraries.baselogic.BasePresenter
import com.example.android.popularlibraries.data.entity.GithubUser
import com.example.android.popularlibraries.data.repositories.GithubUsersRepository
import com.example.android.popularlibraries.helpers.schedules.AppSchedulers
import com.example.android.popularlibraries.helpers.screens.ImageCompressorScreen
import com.example.android.popularlibraries.helpers.screens.UserScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.kotlin.plusAssign

class UsersPresenter constructor(
    private val userRepository: GithubUsersRepository,
    private val appSchedulers: AppSchedulers,
    router: Router,
) : BasePresenter<UsersView>(router) {

    class UsersUserListPresenter : UsersListPresenter {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.currentPosition]
            view.setLogin(user.login)
            view.setAvatar(user)
        }
    }

    val usersListPresenter = UsersUserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        disposables +=
            userRepository
                .getUsers()
                .observeOn(appSchedulers.main())
                .subscribeOn(appSchedulers.background())
                .subscribe(
                    { gitHubUsers ->
                        usersListPresenter.users.addAll(gitHubUsers)
                        viewState.updateList()
                    },
                    { exception -> viewState.showException(exception) }
                )

        usersListPresenter.itemClickListener = {
            val userLogin = usersListPresenter.users[it.currentPosition].login
            router.navigateTo(UserScreen(userLogin))
        }
    }

    fun openWinImageCompressor() {
        router.navigateTo(ImageCompressorScreen())
    }
}