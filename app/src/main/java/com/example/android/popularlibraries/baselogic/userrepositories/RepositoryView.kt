package com.example.android.popularlibraries.baselogic.userrepositories

import com.example.android.popularlibraries.baselogic.ExceptionView
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface RepositoryView : MvpView, ExceptionView {

    fun showInfo(text: String)
}