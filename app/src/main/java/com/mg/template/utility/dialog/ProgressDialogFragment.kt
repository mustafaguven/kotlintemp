package com.mg.template.utility.dialog

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.mg.template.R
import kotlinx.android.synthetic.main.progress_layout.lblProgress

class ProgressDialogFragment : DialogFragment() {

  val isShowing: Boolean
    get() = dialog != null && dialog.isShowing

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.progress_layout, container)
    dialog.window.setBackgroundDrawable(ColorDrawable(0))
    dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
    dialog.setCanceledOnTouchOutside(false)
    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setText(arguments!!.getString(
        TEXT))
  }

  override fun onStart() {
    super.onStart()
    val dialog = dialog
    if (dialog != null) {
      val width = ViewGroup.LayoutParams.MATCH_PARENT
      val height = ViewGroup.LayoutParams.WRAP_CONTENT
      dialog.window.setLayout(width, height)
    }
  }

  fun setText(text: String?) {
    lblProgress.text = text
  }

  companion object {
    private val TEXT = "TEXT"

    fun newInstance(text: String): ProgressDialogFragment {
      val fragment = ProgressDialogFragment()
      val args = Bundle()
      args.putSerializable(TEXT, text)
      fragment.arguments = args
      return fragment
    }
  }
}
