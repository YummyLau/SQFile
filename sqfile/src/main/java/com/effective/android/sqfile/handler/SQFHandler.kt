package com.effective.android.sqfile.handler

import androidx.annotation.WorkerThread
import com.effective.android.sqfile.param.SQFParameter
import com.effective.android.sqfile.result.ResultCallback
import com.effective.android.sqfile.result.SQFResult
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

abstract class SQFHandler() {

    abstract fun enqueue(responseCallback: ResultCallback)

    @WorkerThread
    abstract fun execute(): SQFResult

}