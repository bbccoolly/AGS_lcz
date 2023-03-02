package com.ags.lcz.core.network

import javax.inject.Qualifier

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-02
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val lczAppDispatchers: LczAppDispatchers)

enum class LczAppDispatchers {
    IO
}

