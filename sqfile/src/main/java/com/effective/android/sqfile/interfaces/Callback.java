package com.effective.android.sqfile.interfaces;

import com.effective.android.sqfile.SQFile;
import com.effective.android.sqfile.bean.SQResult;

import java.io.IOException;

public interface Callback {

    void onFailure(SQFile sqFile, IOException e);

    void onResponse(SQFile sqFile, SQResult response) throws IOException;
}
