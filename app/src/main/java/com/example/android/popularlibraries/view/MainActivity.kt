package com.example.android.popularlibraries.view

import com.example.android.popularlibraries.App.Navigation.navigatorHolder
import com.example.android.popularlibraries.App.Navigation.router
import com.example.android.popularlibraries.R
import com.example.android.popularlibraries.presenter.BackButtonListener
import com.example.android.popularlibraries.presenter.MainPresenter
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    private val presenter by moxyPresenter { MainPresenter(router) }
    private val navigator = AppNavigator(this, R.id.container)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.back()
    }
}