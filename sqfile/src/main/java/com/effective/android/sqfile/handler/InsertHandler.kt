package com.effective.android.sqfile.handler

import android.text.TextUtils
import com.effective.android.sqfile.SQFUtils
import com.effective.android.sqfile.SQFile
import com.effective.android.sqfile.param.InsertParameter
import com.effective.android.sqfile.param.QueryParameter
import com.effective.android.sqfile.param.anno.ExpressionStrategy
import com.effective.android.sqfile.result.ResultCallback
import com.effective.android.sqfile.result.SQFResult
import java.io.File

class InsertHandler(private val sqfParameter: InsertParameter) : SQFHandler() {

    override fun enqueue(responseCallback: ResultCallback) {
        SQFile.threadPoolExecutor.execute {
            SQFile.handler.post {
                responseCallback.onResponse(execute())
            }
        }
    }

    override fun execute(): SQFResult {
//        val parentPath = sqfParameter.fileScope.realPath()
//        val exist = SQFUtils.createOrExistDir(parentPath)
//        if (!exist) {
//            return SQFResult(false, "创建目录($parentPath)失败")
//        }
//        if(TextUtils.isEmpty(sqfParameter.targetExpression)){
//            return SQFResult(false, "插入文件名不能为空")
//        }
//        val targetFile = File(parentPath, sqfParameter.targetExpression)
//        val filter = FileFilter {
//            var result = if (sqfParameter.expressionStrategy == ExpressionStrategy.EQUALS) {
//                TextUtils.equals(it.name, sqfParameter.targetExpression)
//            } else {
//                it.name.matches(Regex(sqfParameter.targetExpression))
//            }
//            result
//        }
//        val resultList = SQFUtils.deleteFilesInDirWithFilter(file, filter, sqfParameter.levelStrategy)
//        val success = resultList.isNotEmpty()
//        val message = if (success) "" else "目标(${sqfParameter.targetExpression})在路径($filePath)下不存在"
        return SQFResult(false, "")
    }
}