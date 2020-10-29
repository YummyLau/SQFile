package com.effective.android.sqfile.scope.app

import android.text.TextUtils
import com.effective.android.sqfile.scope.FileScope
import java.io.File

abstract class AppFileScope(private val splicingPath: String = "") : FileScope {

    protected val file: File
        get() = root()

    override fun permissionLimit(): Boolean = false

    override fun realPath(): String {
        return appendRealPath(file.absolutePath, splicingPath)
    }

    /**
     * splicingPath 处理 "/" 开头的规则，以 "/" 结尾的规则对 [File] 构建无影响
     */
    private fun appendRealPath(root: String, splicingPath: String): String {
        return when {
            TextUtils.isEmpty(splicingPath) -> {
                root
            }
            splicingPath.startsWith("/") -> {
                "${root}${splicingPath}"
            }
            else -> {
                "${root}/${splicingPath}"
            }
        }
    }
}