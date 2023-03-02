package com.ags.lcz.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-02
 */
class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        Timber.d("HttpRequestInterceptor - ", request.toString())


        return chain.proceed(request)
    }
}