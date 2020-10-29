package com.effective.android.sqfile.scope.app

import android.os.Environment
import android.text.TextUtils
import com.effective.android.sqfile.SQFile
import java.io.File

class AppStorageFilesScope(private val type: String? = null, splicingPath: String = "") : AppFileScope(splicingPath) {

    override fun root(): File {
        var file: File? = null
        if (TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = SQFile.context.getExternalFilesDir(type)
        }
        return file ?: SQFile.context.filesDir
    }
}