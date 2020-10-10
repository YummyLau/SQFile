package com.effective.android.sqfile.bean;

import java.io.File;

public abstract class SQParameter {
    File targetFile;
    String targetPath;

    public SQParameter(File targetFile) {
        this.targetFile = targetFile;
    }

    public SQParameter(String targetPath) {
        this.targetPath = targetPath;
    }
}