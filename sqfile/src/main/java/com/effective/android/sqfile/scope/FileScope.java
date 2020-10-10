package com.effective.android.sqfile.scope;


import java.io.File;

public interface FileScope {

    boolean needPermission();

    File file();

    String path();
}
