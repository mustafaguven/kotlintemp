package com.mg.template.mvp.presenter.splash

import com.mg.template.cache.ApplicationCache
import com.mg.template.domain.request.SplashRequest
import com.mg.template.domain.response.SplashResponse
import com.mg.template.mvp.contract.SplashContract
import com.mg.template.mvp.interactor.splash.SplashInteractor
import com.mg.template.network.InitService
import com.mg.template.utility.DeviceUtil
import com.mg.template.utility.FileUtil
import com.mg.template.utility.rx.TestSchedulerProvider
import com.mg.template.wrapper.UriWrapper
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doNothing
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.io.File

class SplashPresenterTest {

  private val contract: SplashContract.View = mock()
  private lateinit var interactor: SplashInteractor
  private val initService: InitService = mock()
  private val compositeDisposable: CompositeDisposable = mock()
  private val cache: ApplicationCache = mock()
  private val fileUtil: FileUtil = mock()
  private val uriWrapper: UriWrapper = mock()
  private val deviceUtil: DeviceUtil = mock()
  private lateinit var presenter: SplashContract.Presenter
  private lateinit var spyPresenter: SplashContract.Presenter
  private lateinit var testScheduler: TestScheduler

  @Before
  fun setUp() {
    testScheduler = TestScheduler()
    interactor = SplashInteractor(initService, TestSchedulerProvider(testScheduler))

    presenter = SplashPresenter(contract, interactor, uriWrapper, compositeDisposable,
        cache, fileUtil, deviceUtil)
    spyPresenter = Mockito.spy(presenter)

  }

  @Test
  fun should_CallShowVideo_AND_CallInit_whenOnCreate() {
    doNothing().whenever(spyPresenter).showVideo()
    doNothing().whenever(spyPresenter).callInit()

    spyPresenter.onCreate()
    verify(spyPresenter).showVideo()
    verify(spyPresenter).callInit()
  }


  @Test
  fun should_ShowVideo_when_CommercialLink_AND_VideoFileExists() {
    whenever(cache.getCommercialLink()).thenReturn("kivanc.mp4")
    val file: File = mock()
    whenever(fileUtil.getIntroVideoFile(any())).thenReturn(file)
    whenever(file.exists()).thenReturn(true)
    whenever(uriWrapper.parseUriFromFile(file)).thenReturn(UriWrapper())
    presenter.showVideo()
    verify(contract).showVideoView(any())

  }

  @Test
  fun should_Dispose_CompositeDisposable_If_Is_NOT_Disposed_whenOnDestroy() {
    val isDisposed = false
    whenever(compositeDisposable.isDisposed).thenReturn(isDisposed)
    presenter.onDestroy()
    verify(compositeDisposable).dispose()
  }


  @Test
  fun should_NOT_Dispose_CompositeDisposable_If_is_Disposed_Already_whenOnDestroy() {
    val isDisposed = true
    whenever(compositeDisposable.isDisposed).thenReturn(isDisposed)
    presenter.onDestroy()
    verify(compositeDisposable, never()).dispose()
  }

  @Test
  fun should_update_commerciallink_AND_updateScreen_when_callInit() {
    val request = SplashRequest.Init("android", "version", "osversion")
    val responseInit = SplashResponse.Init(false, false,
        "updatelink", "message", "useragreement", "commerciallink")

    //val baseSplashResponse: BaseResponse<SplashResponse.Init> = BaseResponse()
    whenever(deviceUtil.osVersion).thenReturn("version")
    whenever(deviceUtil.apiVersion).thenReturn("osversion")

    //val observer = TestObserver<SplashResponse>()

//    whenever(initService.init(request)).thenReturn(
//        Observable.just(baseSplashResponse))

    whenever(interactor.getInit(request)).thenReturn(
        Observable.just(responseInit))


    presenter.callInit()

    testScheduler.triggerActions()
//    verify(contract).hideProgress()
//    verify(contract).updateScreen()
  }
}