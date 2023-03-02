package com.ags

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 *
 * desc: @HiltAndroidApp 会触发 Hilt 的代码生成操作，生成的代码包括应用的一个基类，该基类充当应用级依赖项容器。
 *
 * create by lcz on 2023-03-02
 */
@HiltAndroidApp
class LczApplication : Application()