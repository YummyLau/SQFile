package com.effective.android.sqfile.result

import java.io.File

class SQFResult(val success: Boolean, val message: String = "", val files: MutableList<File> = mutableListOf())