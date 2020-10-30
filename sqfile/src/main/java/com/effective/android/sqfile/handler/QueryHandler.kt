package com.effective.android.sqfile.handler

import android.text.TextUtils
import com.effective.android.sqfile.SQFUtils
import com.effective.android.sqfile.SQFile
import com.effective.android.sqfile.param.QueryParameter
import com.effective.android.sqfile.param.anno.ExpressionStrategy
import com.effective.android.sqfile.result.ResultCallback
import com.effective.android.sqfile.result.SQFResult
import java.io.FileFilter


class QueryHandler(private val sqfParameter: QueryParameter) : SQFHandler() {

    override fun enqueue(responseCallback: ResultCallback) {
        SQFile.threadPoolExecutor.execute {
            SQFile.handler.post {
                responseCallback.onResponse(execute())
            }
        }
    }

    override fun execute(): SQFResult {
        val filePath = sqfParameter.fileScope.realPath()
        val file = SQFUtils.getFileByPath(filePath)
        if (file == null || !file.exists()) {
            return SQFResult(false, "文件($filePath)不存在")
        }
        val filter = FileFilter {
            var result = if (sqfParameter.expressionStrategy == ExpressionStrategy.EQUALS) {
                TextUtils.equals(it.name, sqfParameter.targetExpression)
            } else {
                it.name.matches(Regex(sqfParameter.targetExpression))
            }
            result
        }
        val resultList = SQFUtils.listFilesInDirWithFilter(file, filter, sqfParameter.levelStrategy)
        val success = resultList.isNotEmpty()
        val message = if (success) "" else "目标(${sqfParameter.targetExpression})在路径($filePath)下不存在"
        return SQFResult(success, message, resultList)
    }

}
