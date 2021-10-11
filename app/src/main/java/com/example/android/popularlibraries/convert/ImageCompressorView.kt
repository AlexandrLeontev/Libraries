package com.example.android.popularlibraries.convert

import android.content.Intent
import android.net.Uri
import com.example.android.popularlibraries.baselogic.ExceptionView
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface ImageCompressorView : MvpView, ExceptionView {

    fun startSelectImage()

    fun endSelectImage()

    fun processSaveImage(asStarted: Boolean)

    fun showSavedImage(uri: Uri)

    fun openIntent(intent: Intent)

    fun showImageProperties(properties: String)
}