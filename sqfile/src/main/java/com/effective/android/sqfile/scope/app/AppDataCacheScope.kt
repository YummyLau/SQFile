package com.effective.android.sqfile.scope.app

import com.effective.android.sqfile.SQFile
import java.io.File

/**
 * /data/data/{packageName}/cache 空间
 * created by yummylau on 2020/10/10
 */
class AppDataCacheScope(splicingPath: String = "") : AppFileScope(splicingPath) {

    override fun root(): File {
        return  SQFile.context.cacheDir
    }
}