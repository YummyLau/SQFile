package com.effective.android.sqfile.param

import com.effective.android.sqfile.param.anno.ExpressionStrategy
import com.effective.android.sqfile.param.anno.LevelStrategy

class DeleteParameter : SQFParameter {

    val expressionStrategy: Int
    val levelStrategy: Int

    @JvmOverloads
    constructor(targetExpression: String,
                @ExpressionStrategy expressionStrategy: Int = ExpressionStrategy.EQUALS,
                @LevelStrategy levelStrategy: Int = LevelStrategy.CURRENT) {
        this.targetExpression = targetExpression
        this.expressionStrategy = expressionStrategy
        this.levelStrategy = levelStrategy
    }
}