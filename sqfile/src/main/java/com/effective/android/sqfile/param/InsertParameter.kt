package com.effective.android.sqfile.param

import com.effective.android.sqfile.param.anno.ConflictStrategy
import java.io.File
import java.io.InputStream

/**
 * 插入文件：新增新文件，更新文件，覆盖文件等操作
 * 策略：[ConflictStrategy] 覆盖/中止/异常
 * 覆盖：已存在命中文件则覆盖已有文件
 * 中止：已存在命中文件则中止流程
 * 异常：已存在命中文件则异常
 * created by yummylau on 2020/10/27
 */
class InsertParameter : SQFParameter {

    private var inputFile: File? = null
    private var inputPath: String? = null
    private var inputStream: InputStream? = null

    @ConflictStrategy
    var conflictStrategy: Int = ConflictStrategy.REPLACE

    @JvmOverloads
    constructor(inputFile: File? = null, targetFileName: String, @ConflictStrategy conflictStrategy: Int = ConflictStrategy.REPLACE) {
        this.inputFile = inputFile
        this.conflictStrategy = conflictStrategy
        this.targetExpression = targetFileName
    }

    @JvmOverloads
    constructor(inputPath: String, targetFileName: String, @ConflictStrategy conflictStrategy: Int = ConflictStrategy.REPLACE) {
        this.inputPath = inputPath
        this.conflictStrategy = conflictStrategy
        this.targetExpression = targetFileName
    }

    @JvmOverloads
    constructor(inputStream: InputStream?, targetFileName: String, @ConflictStrategy conflictStrategy: Int = ConflictStrategy.REPLACE) {
        this.inputStream = inputStream
        this.conflictStrategy = conflictStrategy
        this.targetExpression = targetFileName
    }
}
