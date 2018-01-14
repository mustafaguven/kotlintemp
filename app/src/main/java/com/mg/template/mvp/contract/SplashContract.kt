package com.mg.template.mvp.contract

import com.mg.template.domain.request.SplashRequest
import com.mg.template.domain.response.SplashResponse
import com.mg.template.mvp.presenter.BasePresenter
import com.mg.template.mvp.view.BaseView
import com.mg.template.wrapper.UriWrapper
import io.reactivex.Observable
import java.io.File

interface SplashContract {

  interface View : BaseView {
  }

  interface Presenter : BasePresenter {
  }

  interface Interactor {

  }
}
