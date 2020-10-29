package com.effective.android.sqfile.scope

import java.io.File

interface FileScope {
    fun permissionLimit(): Boolean
    fun root(): File
    fun realPath(): String
}