package com.effective.android.sqfile.bean;

import com.effective.android.sqfile.anno.ConflictStrategy;

import java.io.File;
import java.io.InputStream;

public class InsertParameter extends SQParameter {

    private File inputFile;
    private String inputPath;
    private InputStream inputStream;

    private String targetFileName;

    @ConflictStrategy
    private int conflictStrategy = ConflictStrategy.REPLACE;

    /**
     * 插入一个空文件
     *
     * @param targetFileName
     */
    public InsertParameter(String targetFileName) {
        this.targetFileName = targetFileName;
    }

    public InsertParameter(String targetFileName, int conflictStrategy) {
        this.targetFileName = targetFileName;
        this.conflictStrategy = conflictStrategy;
    }

    public InsertParameter(File inputFile, String targetFileName) {
        this.inputFile = inputFile;
        this.targetFileName = targetFileName;
    }

    public InsertParameter(String inputPath, String targetFileName) {
        this.inputPath = inputPath;
        this.targetFileName = targetFileName;
    }

    public InsertParameter(InputStream inputStream, String targetFileName) {
        this.inputStream = inputStream;
        this.targetFileName = targetFileName;
    }

    public InsertParameter(File inputFile, String targetFileName, int conflictStrategy) {
        this.inputFile = inputFile;
        this.targetFileName = targetFileName;
        this.conflictStrategy = conflictStrategy;
    }

    public InsertParameter(String inputPath, String targetFileName, int conflictStrategy) {
        this.inputPath = inputPath;
        this.targetFileName = targetFileName;
        this.conflictStrategy = conflictStrategy;
    }

    public InsertParameter(InputStream inputStream, String targetFileName, int conflictStrategy) {
        this.inputStream = inputStream;
        this.targetFileName = targetFileName;
        this.conflictStrategy = conflictStrategy;
    }
}
