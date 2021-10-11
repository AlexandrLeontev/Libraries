package com.example.android.popularlibraries.baselogic.user

import com.example.android.popularlibraries.baselogic.BasePresenter
import com.example.android.popularlibraries.data.repositories.GithubUsersRepository
import com.example.android.popularlibraries.data.repositories.UserAvatarRepository
import com.example.android.popularlibraries.helpers.schedules.AppSchedulers
import com.example.android.popularlibraries.helpers.screens.RepositoryScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.plusAssign

class UserPresenter constructor(
    private val userRepository: GithubUsersRepository,
    private val appSchedulers: AppSchedulers,
    private val userAvatarRepository: UserAvatarRepository,
    router: Router,
    val repositoryListPresenter: RepositoryListPresenter,
    private val userLogin: String?,
) : BasePresenter<UserView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        userLogin?.let {
            disposables += loadUserInfo(it)

            disposables += loadRepositoriesInfo(it)

            repositoryListPresenter.itemClickListener = { item ->
                val repositoryName = repositoryListPresenter.repositories[item.currentPosition].name
                router.navigateTo(RepositoryScreen(it, repositoryName))
            }

        } ?: let {
            viewState.showException(Throwable("Пустой логин пользователя"))
        }
    }

    private fun loadRepositoriesInfo(login: String): Disposable {
        return userRepository
            .getRepositories(login)
            .observeOn(appSchedulers.main())
            .subscribeOn(appSchedulers.background())
            .subscribe(
                { repositories ->
                    repositoryListPresenter.repositories.addAll(repositories)
                    viewState.updateRepositoryList()
                },

                { exception -> viewState.showException(exception) }
            )
    }

    private fun loadUserInfo(login: String): Disposable {
        return userRepository
            .getUser(login)
            .observeOn(appSchedulers.main())
            .subscribeOn(appSchedulers.background())
            .subscribe(
                { gitHubUser ->
                    viewState.showUser(gitHubUser, userAvatarRepository.imageBuilder(gitHubUser))
                },

                { exception -> viewState.showException(exception) }
            )
    }
}