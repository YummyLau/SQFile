package com.effective.android.sqfile.scope.app;

import com.effective.android.sqfile.SQFile;
import com.effective.android.sqfile.scope.FileScope;

import java.io.File;

/**
 * /data/data/{packageName}/files 空间
 * created by yummylau on 2020/10/10
 */
public class AppDataFilesScope extends AppFileScope {

    @Override
    public boolean needPermission() {
        return false;
    }

    @Override
    public String path() {
        if (file == null) {
            file();
        }
        return file.getAbsolutePath();
    }

    @Override
    public File file() {
        if (file == null) {
            file = SQFile.getContext().getFilesDir();
        }
        return file;
    }

}