package com.effective.android.sqfile.handler

import com.effective.android.sqfile.param.InsertParameter
import com.effective.android.sqfile.param.QueryParameter
import com.effective.android.sqfile.result.ResultCallback
import com.effective.android.sqfile.result.SQFResult

class InsertHandler(private val sqfParameter: InsertParameter) : SQFHandler() {

    override fun enqueue(responseCallback: ResultCallback) {

    }

    override fun execute(): SQFResult {
        return SQFResult(false)
    }
}