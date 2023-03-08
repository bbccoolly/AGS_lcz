package com.ags.lcz.initializer

import android.content.Context
import androidx.startup.Initializer
import com.ags.lcz.BuildConfig
import timber.log.Timber

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-08
 */
class TimberInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("TimberInitializer is initialized.")
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}