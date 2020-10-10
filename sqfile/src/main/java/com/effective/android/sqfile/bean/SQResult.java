package com.effective.android.sqfile.bean;

import java.util.List;

public class SQResult {
    boolean success;
    String path;
    List<String> paths;

    public SQResult(boolean success, String path, List<String> paths) {
        this.success = success;
        this.path = path;
        this.paths = paths;
    }
}
