package com.effective.android.sqfile

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.effective.android.sqfile.param.*
import com.effective.android.sqfile.scope.FileScope
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

object SQFile {

    internal lateinit var handler: Handler
    internal lateinit var threadPoolExecutor: ThreadPoolExecutor
    internal lateinit var context: Context

    /**
     * 初始化context
     */
    internal fun init(context: Context) {
        this.context = context
        this.handler = Handler(Looper.getMainLooper())
        this.threadPoolExecutor = ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS, LinkedBlockingDeque<Runnable>(100))
    }

    @JvmStatic
    fun insert(fileScope: FileScope): SQFParameterAdapter<InsertParameter> {
        return SQFParameterAdapter(fileScope)
    }

    @JvmStatic
    fun delete(fileScope: FileScope): SQFParameterAdapter<DeleteParameter> {
        return SQFParameterAdapter(fileScope)
    }

    @JvmStatic
    fun query(fileScope: FileScope): SQFParameterAdapter<QueryParameter> {
        return SQFParameterAdapter(fileScope)
    }

}