package com.effective.android.sqfile;

import android.content.Context;

import androidx.annotation.WorkerThread;

import com.effective.android.sqfile.bean.InsertParameter;
import com.effective.android.sqfile.bean.SQParameter;
import com.effective.android.sqfile.bean.SQResult;
import com.effective.android.sqfile.interfaces.Callback;
import com.effective.android.sqfile.scope.FileScope;

public class SQFile {

    private static Context sContext;
    FileScope fileScope;
    String dir;
    SQParameter parameter;

    static void init(Context context) {
        sContext = context;
    }

    public static Context getContext() {
        return sContext;
    }

    private SQFile(FileScope fileScope, String dir) {
        this.fileScope = fileScope;
        this.dir = dir;
    }

    public static SQFile create(FileScope fileScope) {
        return new SQFile(fileScope, null);
    }

    public static SQFile create(FileScope fileScope, String appendDir) {
        return new SQFile(fileScope, appendDir);
    }

    public SQFile insert(InsertParameter parameter) {
        this.parameter = parameter;
        return this;
    }


    public void enqueue(Callback responseCallback) {

    }

    @WorkerThread
    public SQResult execute() {
        return null;
    }

    public SQFile delete() {
        return this;
    }

    public SQFile query() {
        return this;
    }
}
