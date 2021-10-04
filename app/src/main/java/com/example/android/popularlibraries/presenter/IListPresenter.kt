package com.example.android.popularlibraries.presenter

import com.example.android.popularlibraries.view.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}