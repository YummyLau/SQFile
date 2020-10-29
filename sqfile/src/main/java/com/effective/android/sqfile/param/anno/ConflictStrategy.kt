package com.effective.android.sqfile.param.anno

import androidx.annotation.IntDef

@Retention(AnnotationRetention.SOURCE)
@IntDef(ConflictStrategy.REPLACE, ConflictStrategy.ABORT, ConflictStrategy.ERROR)
annotation class ConflictStrategy {
    companion object {
        const val REPLACE = 1   //覆盖
        const val ABORT = 2     //中止
        const val ERROR = 3     //异常
    }
}