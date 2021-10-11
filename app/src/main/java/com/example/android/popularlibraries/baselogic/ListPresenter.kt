package com.example.android.popularlibraries.baselogic

interface ListPresenter<T> {

    var itemClickListener: ((T) -> Unit)?

    fun bindView(view: T)

    fun getCount(): Int
}