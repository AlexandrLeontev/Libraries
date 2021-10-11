package com.example.android.popularlibraries.convert

import android.graphics.Bitmap
import android.net.Uri
import io.reactivex.rxjava3.core.Single

interface ImageConverter {

    fun convert(bitmap: Bitmap, imageCompressorPercent: Int, imageSizePercent: Int): Single<Uri>
}