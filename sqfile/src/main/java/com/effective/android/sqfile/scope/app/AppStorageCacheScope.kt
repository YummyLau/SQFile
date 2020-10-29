package com.effective.android.sqfile.scope.app

import android.os.Environment
import android.text.TextUtils
import com.effective.android.sqfile.SQFile
import java.io.File

class AppStorageCacheScope(splicingPath: String = "") : AppFileScope(splicingPath) {

    override fun root(): File {
        var file: File? = null
        if (TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = SQFile.context.externalCacheDir
        }
        return file ?: SQFile.context.cacheDir
    }
}