package com.effective.android.sqfile.scope.app;

import android.os.Environment;
import android.text.TextUtils;

import com.effective.android.sqfile.SQFile;
import com.effective.android.sqfile.scope.FileScope;

import java.io.File;

public class AppStorageFilesScope extends AppFileScope {

    public String type;

    public AppStorageFilesScope() {
    }

    public AppStorageFilesScope(String type) {
        this.type = type;
    }

    @Override
    public boolean needPermission() {
        return false;
    }

    @Override
    public String path() {
        if(file == null){
            file();
        }
        return file.getAbsolutePath();
    }

    @Override
    public File file() {
        if(file == null){
            if (TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                file = SQFile.getContext().getExternalFilesDir(type);
                if(file == null){
                    file = SQFile.getContext().getFilesDir();
                }
            }
        }
        return file;
    }
}
