package com.example.android.popularlibraries.model.api

import com.example.android.popularlibraries.BuildConfig.GITHUB_USER_NAME
import com.example.android.popularlibraries.BuildConfig.GITHUB_USER_PASS
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

object GithubApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("Authorization", Credentials.basic(GITHUB_USER_NAME, GITHUB_USER_PASS))
                .build()
        )
}