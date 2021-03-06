package com.effective.android.sqfile

import android.content.ContentResolver
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.text.TextUtils
import com.effective.android.sqfile.param.anno.LevelStrategy
import java.io.File
import java.io.FileFilter
import java.io.FileNotFoundException
import java.io.IOException

object SQFUtils {

    @JvmStatic
    fun isStorageLegacy(): Boolean = Environment.isExternalStorageLegacy()

    @JvmStatic
    fun isSpace(s: String?): Boolean {
        if (s == null) {
            return false
        }
        val chars = s.toCharArray()
        for (c in chars) {
            if (!Character.isWhitespace(c)) {
                return false
            }
        }
        return true
    }

    @JvmStatic
    fun getFileByPath(path: String?): File? {
        if (isSpace(path)) {
            return null
        }
        return File(path)
    }

    @JvmStatic
    fun isFileExists(file: File?): Boolean {
        if (file == null) return false
        return if (file.exists()) {
            true
        } else isFileExists(file.absolutePath)
    }

    @JvmStatic
    fun isFileExists(filePath: String?): Boolean {
        val file: File = getFileByPath(filePath) ?: return false
        return if (file.exists()) {
            true
        } else isFileExistsApi29(filePath)
    }

    private fun isFileExistsApi29(filePath: String?): Boolean {
        if (TextUtils.isEmpty(filePath) && Build.VERSION.SDK_INT >= 29) {
            try {
                val uri = Uri.parse(filePath)
                val cr: ContentResolver = SQFile.context.contentResolver
                val afd = cr.openAssetFileDescriptor(uri, "r") ?: return false
                try {
                    afd.close()
                } catch (ignore: IOException) {
                }
            } catch (e: FileNotFoundException) {
                return false
            }
            return true
        }
        return false
    }

    @JvmStatic
    fun isDirectory(file: File?): Boolean = file != null && file.exists() && file.isDirectory

    @JvmStatic
    fun listFilesInDirWithFilter(dir: File,
                                 filter: FileFilter,
                                 @LevelStrategy levelStrategy: Int = LevelStrategy.CURRENT): MutableList<File> {
        val result = mutableListOf<File>()
        if (!dir.exists()) return result
        if (!isDirectory(dir)) return result
        val subFiles = dir.listFiles()
        subFiles?.let {
            for (file in subFiles) {
                if (filter.accept(file)) {
                    result.add(file)
                }
                if (levelStrategy == LevelStrategy.RECURSIVE && file.isDirectory) {
                    result.addAll(listFilesInDirWithFilter(file, filter, levelStrategy))
                }
            }
        }
        return result
    }

    @JvmStatic
    fun deleteFilesInDirWithFilter(dir: File,
                                   filter: FileFilter,
                                   @LevelStrategy levelStrategy: Int = LevelStrategy.CURRENT): MutableList<File> {
        val result = mutableListOf<File>()
        if (!dir.exists()) return result
        if (!isDirectory(dir)) return result
        val subFiles = dir.listFiles()
        subFiles?.let {
            for (file in subFiles) {
                if (levelStrategy == LevelStrategy.CURRENT) {
                    deleteFile(file, filter, result)
                } else {
                    delete(file, filter, result)
                }
            }
        }
        return result
    }

    private fun delete(file: File?, filter: FileFilter? = null, mutableList: MutableList<File>? = null): Boolean {
        if (file == null) return false
        if (file.isDirectory) {
            return deleteDir(file, filter, mutableList)
        }
        return deleteFile(file, filter, mutableList)
    }

    private fun deleteFile(file: File?, filter: FileFilter? = null, mutableList: MutableList<File>? = null): Boolean {
        if (file != null && (!file.exists() || file.isFile && file.delete())) {
            var accept = true
            filter?.let {
                accept = it.accept(file)
            }
            if (accept) {
                mutableList?.add(file)
            }
            return accept
        }
        return false
    }

    private fun deleteDir(dir: File?, filter: FileFilter? = null, mutableList: MutableList<File>? = null): Boolean {
        if (dir == null) return false
        if (!dir.exists()) return true
        if (!dir.isDirectory) return false
        val files = dir.listFiles()
        if (files != null && files.isNotEmpty()) {
            for (file in files) {
                if (file.isFile) {
                    val resultDel = deleteFile(file, filter, mutableList)
                    if (resultDel) {
                        mutableList?.add(file)
                    } else {
                        return false
                    }
                } else if (file.isDirectory) {
                    if (!deleteDir(file, filter, mutableList)) return false
                }
            }
        }
        return dir.delete()
    }

    @JvmStatic
    fun createOrExistDir(dirPath: String?): Boolean = createOrExistDir(getFileByPath(dirPath))

    @JvmStatic
    fun createOrExistDir(file: File?): Boolean {
        return file != null && (if (file.exists()) file.isDirectory else file.mkdirs())
    }
}