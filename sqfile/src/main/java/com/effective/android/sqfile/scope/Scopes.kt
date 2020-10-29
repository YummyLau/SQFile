package com.effective.android.sqfile.scope

import android.os.Environment
import com.effective.android.sqfile.scope.app.*

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