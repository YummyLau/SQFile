package com.effective.android.sqfile.scope

import android.graphics.BitmapFactory
import android.os.Environment
import com.effective.android.sqfile.scope.app.*
import java.io.File
import java.io.FileInputStream

/***
 * android 10 存储进行了分区存储限制，改用沙河模式，app 只能应用目录下的文件及公共目录文件。*
 * 下面这四部分存储属于私有应用私有目录，与 Android 10 之前的版本处理一直。
 * [com.effective.android.sqfile.scope.Scopes.internalFiles] 内部存储，私有目录      所有版本免权限
 * [com.effective.android.sqfile.scope.Scopes.internalCache] 内部存储，私有目录      所有版本免权限
 * [com.effective.android.sqfile.scope.Scopes.externalFiles] 外部存储，私有目录      4.4以上免权限
 * [com.effective.android.sqfile.scope.Scopes.externalCache] 外部存储，私有目录      4.4以上免权限
 *
 * 共享资源文件
 * DCIM，Pictures,Alarms,Music,Notifications,Podcasts,Ringtones,Movies,Download
 * 媒体文件一般存放在 Music/Movies/Pictures，使用  [android.provider.MediaStore] 操作
 * 非媒体文件一般存放在 Downloads，使用 Storage Access Framework（SAF） 操作
 *
 *
 *
 * 对于共享目录下资源， Android 10 无法通过 File Path 路径访问，需要切换成 [android.provider.MediaStore] 或者 Storage Access Framework(SAF) 方式访问
 * < 10.0 版本，使用 [android.os.Environment.getExternalStorageDirectory] 需要权限
 * < 10.0 版本，使用 SAF 免权限
 *
 * >= 10.0版本，使用 [android.provider.MediaStore] API 访问需要权限 WRITE_EXTERNAL_STORAGE
 * >= 10.0 版本，使用 SAF 访问需要权限
 * >= 10.0版本，使用 [android.provider.MediaStore] API 创建免权限
 * >= 10.0 版本，使用 SAF 创建免权限
 *
 * >= 10.0 版本 受影响的 API 有
 * [java.io.File.createNewFile]
 * [java.io.File.delete]
 * [java.io.File.renameTo]
 * [java.io.File.mkdir]
 * [java.io.File.mkdirs]
 * [java.io.FileInputStream]
 * [java.io.FileOutputStream]
 * [android.graphics.BitmapFactory]
 *
 * 使用 [android.os.Environment.isExternalStorageLegacy] 来判断是否打开分区存储。
 * 当应用以兼容模式（非分区存储）运行时，覆盖安装之后依然会以兼容模式继续运行，卸载重装之后才会以分区模式运行。
 * targetSDK = 29, 默认开启 Scoped Storage, 但可通过在 manifest 里添加 requestLegacyExternalStorage = true 关闭
 * targetSDK < 29, 默认不开启 Scoped Storage, 但可通过在 manifest 里添加requestLegacyExternalStorage = false 打开
 *
 * android 11，应用以 Android 11 为目标平台后，系统会忽略 requestLegacyExternalStorage 标记，强制执行分区存储
 * 但是如果应用运行在 Android 10 时在清单申明 requestLegacyExternalStorage 为 true 时，则会运行在 Android 10 的设别按照预期继续运行。
 * android 11，限制应用访问其他应用的私有目录，包括内部存储和外部存储。
 *
 * 最佳实践：
 *
 *
 *
 */
object Scopes {

    /**
     * 内部存储，以小米MI5s为例
     * splicingPath 为追加的路径
     *  默认不传 appendDir                 /data/user/0/com.effective.android.sqfile.demo/files
     *  传递 dir1/dir2                    /data/user/0/com.effective.android.sqfile.demo/files/dir1/dir2
     */
    @JvmStatic
    @JvmOverloads
    fun internalFiles(splicingPath: String = ""): FileScope = AppDataFilesScope(splicingPath)

    /**
     * 内部存储，以小米MI5s为例
     * splicingPath 为追加的路径
     *  默认不传 appendDir                 /data/user/0/com.effective.android.sqfile.demo/cache
     *  传递 dir1/dir2                    /data/user/0/com.effective.android.sqfile.demo/cache/dir1/dir2
     */
    @JvmStatic
    @JvmOverloads
    fun internalCache(splicingPath: String = ""): FileScope = AppDataCacheScope(splicingPath)


    /**
     * 外部存储，以小米MI5s为例
     * type 取值为 [Environment]
     * splicingPath 为追加的路径
     * null                                     /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/files
     * Environment.DIRECTORY_MUSIC              /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/files/Music
     * Environment.DIRECTORY_PODCASTS           /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/files/Podcasts
     * Environment.DIRECTORY_RINGTONES          /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/files/Ringtones
     * Environment.DIRECTORY_ALARMS             /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/files/Alarms
     * Environment.DIRECTORY_NOTIFICATIONS      /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/files/Notifications
     * Environment.DIRECTORY_PICTURES           /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/files/Pictures
     * Environment.DIRECTORY_MOVIES             /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/files/Movies
     */
    @JvmStatic
    @JvmOverloads
    fun externalFiles(splicingPath: String = "", type: String? = null): FileScope = AppStorageFilesScope(type, splicingPath)

    /**
     * 外部存储，以小米MI5s为例
     *  splicingPath 为追加的路径
     *  默认不传 appendDir                  /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/cache
     *  传递 dir1/dir2                    /storage/emulated/0/Android/data/com.effective.android.sqfile.demo/cache/dir1/dir2
     */
    @JvmStatic
    @JvmOverloads
    fun externalCache(splicingPath: String = ""): FileScope = AppStorageCacheScope(splicingPath)
}