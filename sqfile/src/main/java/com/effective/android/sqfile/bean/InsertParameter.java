package com.effective.android.sqfile.bean;

import com.effective.android.sqfile.anno.ConflictStrategy;

import java.io.File;

public class InsertParameter extends SQParameter {

    @ConflictStrategy
    int conflictStrategy = ConflictStrategy.REPLACE;

    public InsertParameter(File targetFile) {
        super(targetFile);
    }

    public InsertParameter(String targetPath) {
        super(targetPath);
    }

    public InsertParameter(File targetFile, int conflictStrategy) {
        super(targetFile);
        this.conflictStrategy = conflictStrategy;
    }

    public InsertParameter(String targetPath, int conflictStrategy) {
        super(targetPath);
        this.conflictStrategy = conflictStrategy;
    }
}
