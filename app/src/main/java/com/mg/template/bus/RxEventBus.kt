package com.mg.template.bus

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RxEventBus {

  private val bus = PublishSubject.create<Any>()

  fun send(o: Any) = bus.onNext(o)

  fun toObserverable(): Observable<Any> = bus

  fun hasObservers(): Boolean = bus.hasObservers()

}