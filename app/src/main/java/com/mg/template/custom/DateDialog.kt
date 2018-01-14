package com.mg.template.custom

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import com.mg.template.TemplateApplication
import com.mg.template.event.DatePickedEvent
import java.util.Calendar


class DateDialog : DialogFragment(), DatePickerDialog.OnDateSetListener {

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val calendar = Calendar.getInstance()
    val yy = calendar.get(Calendar.YEAR)
    val mm = calendar.get(Calendar.MONTH)
    val dd = calendar.get(Calendar.DAY_OF_MONTH)
    return DatePickerDialog(activity, this, yy, mm, dd)
  }

  override fun onDateSet(view: DatePicker, yy: Int, mm: Int, dd: Int) {
    val month: String = if (mm >= 10) mm.toString() else "0" + mm
    val day: String = if (dd >= 10) dd.toString() else "0" + dd
    populateSetDate(yy.toString(), month, day)
  }

  fun populateSetDate(year: String, month: String, day: String) {
    if (activity != null && !activity!!.isFinishing) {
      (activity!!.applicationContext as TemplateApplication)
          .bus
          .send(DatePickedEvent("$day.$month.$year"))
    }
  }
}
