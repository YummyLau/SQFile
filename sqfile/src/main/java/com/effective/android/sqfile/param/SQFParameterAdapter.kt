package com.effective.android.sqfile.param

import com.effective.android.sqfile.handler.DeleteHandler
import com.effective.android.sqfile.handler.InsertHandler
import com.effective.android.sqfile.handler.QueryHandler
import com.effective.android.sqfile.handler.SQFHandler
import com.effective.android.sqfile.scope.FileScope
import java.lang.IllegalArgumentException

class SQFParameterAdapter<T : SQFParameter>(private val fileScope: FileScope) {

    fun param(t: T): SQFHandler {
        t.fileScope = fileScope
        return when (t) {
            is InsertParameter -> {
                InsertHandler(t)
            }
            is DeleteParameter -> {
                DeleteHandler(t)
            }
            is QueryParameter -> {
                QueryHandler(t)
            }
            else -> {
                throw IllegalArgumentException("Unknown subtype！")
            }
        }
    }
}