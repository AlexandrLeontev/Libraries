package com.example.android.popularlibraries.view

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView : ScreenView {
    fun init()
    fun updateList()
}