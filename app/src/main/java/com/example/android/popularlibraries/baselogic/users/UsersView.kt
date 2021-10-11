package com.example.android.popularlibraries.baselogic.users

import com.example.android.popularlibraries.baselogic.ExceptionView
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface UsersView : MvpView, ExceptionView {

    fun init()

    fun updateList()
}