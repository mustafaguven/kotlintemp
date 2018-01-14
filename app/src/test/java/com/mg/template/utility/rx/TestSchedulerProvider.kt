package com.mg.template.utility.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider(private val testScheduler: TestScheduler) : SchedulerProvider {
  override fun ui(): Scheduler =
      TestScheduler()

  override fun computation(): Scheduler = TestScheduler()

  override fun io(): Scheduler = TestScheduler()
}