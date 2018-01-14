package com.mg.template.custom

import android.text.Editable
import android.text.TextWatcher

class PhoneTextWatcher(private val view: MaviPhoneEditText) : TextWatcher {

  companion object {
    private val VALID_CHARACTER: String = "5"
  }

  override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
  override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

  override fun afterTextChanged(editable: Editable) {
    val text = editable.toString()
    if (!text.startsWith(VALID_CHARACTER)) {
      view.text.clear()
    }
  }
}