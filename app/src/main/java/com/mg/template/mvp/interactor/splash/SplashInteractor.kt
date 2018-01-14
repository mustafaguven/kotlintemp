package com.mg.template.mvp.interactor.splash

import com.mg.template.mvp.contract.SplashContract
import com.mg.template.network.InitService
import com.mg.template.utility.rx.SchedulerProvider


class SplashInteractor(private val initService: InitService,
    private val schedulerProvider: SchedulerProvider) : SplashContract.Interactor {

}


