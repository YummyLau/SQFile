package com.effective.android.sqfile.param

import com.effective.android.sqfile.scope.FileScope

abstract class SQFParameter {

    lateinit var fileScope: FileScope
    var targetExpression: String = ""
}