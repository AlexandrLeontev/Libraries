package com.example.android.popularlibraries.baselogic.main

import android.util.Log
import com.example.android.popularlibraries.baselogic.BasePresenter
import com.example.android.popularlibraries.helpers.screens.UsersScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observable
import java.util.*
import java.util.concurrent.TimeUnit

class MainPresenter(router: Router) : BasePresenter<MainView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(UsersScreen())
    }

    fun execExampleMap() {
        Observable.fromIterable(listOf("1", "2", "3", "4", "5"))
            .switchMap {
                val delay = Random().nextInt(1000).toLong()
                return@switchMap Observable.just(it + "x").delay(delay,
                    TimeUnit.MILLISECONDS)
            }
            .subscribe(
                { s -> Log.d("My", "onNext: $s") },
                { Log.d("My", "onError: ${it.message}") }
            )
    }
}