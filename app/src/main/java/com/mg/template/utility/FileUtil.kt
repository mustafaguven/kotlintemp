package com.mg.template.utility

import android.net.Uri
import android.os.Environment
import java.io.File

class FileUtil {

  fun getIntroVideoFile(rawName: String): File {
    var fileName = rawName

    if (rawName.contains("http")) {
      fileName = Uri.parse(rawName).lastPathSegment
    }

    return File(Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_DOWNLOADS).absoluteFile, fileName)
  }
}