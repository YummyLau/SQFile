package com.effective.android.sqfile.param.anno

import androidx.annotation.IntDef

@Retention(AnnotationRetention.SOURCE)
@IntDef(LevelStrategy.CURRENT, LevelStrategy.RECURSIVE)
annotation class LevelStrategy {
    companion object {
        const val CURRENT = 1     //目录当前层
        const val RECURSIVE = 2   //递归目录
    }
}