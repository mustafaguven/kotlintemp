package com.mg.template.wrapper

import android.net.Uri
import java.io.File

class UriWrapper {

  var uri: Uri? = null

  fun parseUriFromFile(file: File): UriWrapper {
    this.uri = Uri.fromFile(file)
    return this
  }

}