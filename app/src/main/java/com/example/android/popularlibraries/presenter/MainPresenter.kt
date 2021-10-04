package com.example.android.popularlibraries.presenter

import com.example.android.popularlibraries.view.MainView
import com.example.android.popularlibraries.view.UsersScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(UsersScreen.create())
    }

    fun back() = router.exit()
}