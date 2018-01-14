package com.mg.template.mvp.view

import android.support.annotation.StringRes

interface BaseView {

  fun showProgress(@StringRes res: Int)

  fun showProgress(msg: String)

  fun showProgress()

  fun hideProgress()

  fun onError(error: Throwable?)

  fun onError(res: Int)

}