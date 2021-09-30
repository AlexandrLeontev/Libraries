package com.example.android.popularlibraries.view

import moxy.MvpView
//import moxy.viewstate.strategy.AddToEndSingleStrategy
//import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

//@StateStrategyType(AddToEndSingleStrategy::class)
@SingleState()
interface MainView : MvpView