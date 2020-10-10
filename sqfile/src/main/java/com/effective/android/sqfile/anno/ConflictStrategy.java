package com.effective.android.sqfile.anno;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef({ConflictStrategy.REPLACE, ConflictStrategy.ABORT, ConflictStrategy.ERROR})
public @interface ConflictStrategy {
    int REPLACE = 1;        //替换
    int ABORT = 2;          //中止
    int ERROR = 3;          //异常
}

