package com.effective.android.sqfile.scope;

import android.os.Environment;

import com.effective.android.sqfile.scope.app.AppDataCacheScope;
import com.effective.android.sqfile.scope.app.AppDataFilesScope;
import com.effective.android.sqfile.scope.app.AppFileScope;
import com.effective.android.sqfile.scope.app.AppStorageCacheScope;
import com.effective.android.sqfile.scope.app.AppStorageFilesScope;

public class AppScope {

    //内部存储
    public static final AppFileScope INTERNAL_FILES = new AppDataFilesScope();
    public static final AppFileScope INTERNAL_CACHE = new AppDataCacheScope();

    //外部存储
    public static final AppFileScope EXTERNAL_FILES = new AppStorageFilesScope();
    public static final AppFileScope EXTERNAL_MUSIC = new AppStorageFilesScope(Environment.DIRECTORY_MUSIC);
    public static final AppFileScope EXTERNAL_PODCASTS = new AppStorageFilesScope(Environment.DIRECTORY_PODCASTS);
    public static final AppFileScope EXTERNAL_RINGTONES = new AppStorageFilesScope(Environment.DIRECTORY_RINGTONES);
    public static final AppFileScope EXTERNAL_ALARMS = new AppStorageFilesScope(Environment.DIRECTORY_ALARMS);
    public static final AppFileScope EXTERNAL_NOTIFICATIONS = new AppStorageFilesScope(Environment.DIRECTORY_NOTIFICATIONS);
    public static final AppFileScope EXTERNAL_PICTURES = new AppStorageFilesScope(Environment.DIRECTORY_PICTURES);
    public static final AppFileScope EXTERNAL_MOVIES = new AppStorageFilesScope(Environment.DIRECTORY_MOVIES);
    public static final AppFileScope EXTERNAL_CACHE = new AppStorageCacheScope();
}
