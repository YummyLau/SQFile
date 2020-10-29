package com.effective.android.sqfile.scope.app

import android.os.Environment
import android.text.TextUtils
import com.effective.android.sqfile.SQFile
import java.io.File

/**
 * /data/data/{packageName}/files 空间
 * created by yummylau on 2020/10/10
 */
class AppDataFilesScope(splicingPath: String = "") : AppFileScope(splicingPath) {

    override fun root(): File {
        return SQFile.context.filesDir
    }
}