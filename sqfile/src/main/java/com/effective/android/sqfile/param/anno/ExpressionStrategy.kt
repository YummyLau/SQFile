package com.effective.android.sqfile.param.anno

import androidx.annotation.IntDef

@Retention(AnnotationRetention.SOURCE)
@IntDef(ExpressionStrategy.EQUALS, ExpressionStrategy.REGULAR)
annotation class ExpressionStrategy {
    companion object {
        const val EQUALS = 1    //精准匹配
        const val REGULAR = 2   //正则匹配
    }
}