package com.effective.android.sqfile.result

import com.effective.android.sqfile.SQFile
import java.io.IOException
import java.lang.Exception

interface ResultCallback {
    fun onResponse(response: SQFResult)
}