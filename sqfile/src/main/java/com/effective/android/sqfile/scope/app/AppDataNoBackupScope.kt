package com.effective.android.sqfile.scope.app

import android.annotation.TargetApi
import com.effective.android.sqfile.SQFile
import java.io.File

@TargetApi(21)
class AppDataNoBackupScope(splicingPath: String = "") : AppFileScope(splicingPath) {

    override fun root(): File {
        return SQFile.context.noBackupFilesDir
    }
}