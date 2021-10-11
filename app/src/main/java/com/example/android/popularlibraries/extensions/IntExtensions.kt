package com.example.android.popularlibraries.extensions

import android.content.Context
import android.util.TypedValue
import kotlin.math.roundToInt

fun Int.dp(context: Context): Int =
    TypedValue
        .applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            context.resources.displayMetrics)
        .roundToInt()