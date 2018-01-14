package com.mg.template.custom

import android.content.Context
import android.support.design.widget.TextInputEditText
import android.util.AttributeSet


class MaviPhoneEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextInputEditText(context, attrs, defStyleAttr) {

  init {
    addTextChangedListener(PhoneTextWatcher(this))
  }
}

