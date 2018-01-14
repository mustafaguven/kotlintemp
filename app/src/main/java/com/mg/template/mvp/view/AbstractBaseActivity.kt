package com.mg.template.mvp.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import com.mg.template.TemplateApplication
import com.mg.template.R
import com.mg.template.utility.DeviceUtil
import com.mg.template.utility.dialog.ProgressDialogFragment
import kotlinx.android.synthetic.main.toolbar.view.toolbarTitle
import timber.log.Timber
import javax.inject.Inject


abstract class AbstractBaseActivity : AppCompatActivity() {

  companion object {
    val PERMISSION_STORAGE_RESPONSE_CODE = 1
    val PERMISSION_SMS_RESPONSE_CODE = 2
    val PERMISSION_CAMERA_RESPONSE_CODE = 3
    val STORAGE_PERMISSIONS = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE)
    val SMS_PERMISSION = arrayOf(Manifest.permission.READ_SMS)
    val CAMERA_PERMISSION = arrayOf(Manifest.permission.CAMERA)
  }

  @Inject lateinit var deviceUtil: DeviceUtil
  private var toolbar: Toolbar? = null
  private var progressDialogFragment: ProgressDialogFragment? = null

  protected val templateApplication: TemplateApplication
    get() = application as TemplateApplication

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    inject()
  }

  abstract fun inject()

  protected fun prepareRecyclerviewLayoutManager(view: RecyclerView) {
    val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    view.isNestedScrollingEnabled = false
    view.layoutManager = layoutManager
    view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    val itemAnimator = DefaultItemAnimator()
    /*    itemAnimator.setAddDuration(1000);
    itemAnimator.setRemoveDuration(1000);*/
    view.itemAnimator = itemAnimator
  }

  protected fun setToolbarTitle(toolbar: View, name: String) {
    toolbar.toolbarTitle.visibility = View.VISIBLE
    toolbar.toolbarTitle.text = name
  }

  protected fun generateToolbarAsActionBar(view: Toolbar) {
    this.toolbar = view
    if (toolbar != null) {
      setSupportActionBar(toolbar)
      if (supportActionBar != null) {
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setDisplayShowHomeEnabled(false)
        supportActionBar!!.setHomeButtonEnabled(false)
      }
    }
  }

  fun onError(throwable: Throwable?) {
    Timber.e(throwable)
    hideProgress()
    Toast.makeText(this, throwable?.message, Toast.LENGTH_SHORT).show()
  }

  fun onError(@StringRes res: Int) {
    onError(Throwable(getString(res)))
  }

  protected fun hasPermissions(permissions: Array<String>): Boolean {
    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      permissions
          .filter {
            ActivityCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
          }
          .forEach { return false }
    }
    return true
  }

  protected fun permissionControl(permissions: Array<String>, responseCode: Int) {
    if (!hasPermissions(permissions)) {
      ActivityCompat.requestPermissions(this, permissions, responseCode)
    }
  }

  fun showProgress() {
    showProgress(R.string.default_progress_message)
  }

  fun showProgress(@StringRes res: Int) {
    showProgress(getString(res))
  }

  fun showProgress(msg: String) {
    if (progressDialogFragment != null && progressDialogFragment!!.isShowing) {
      progressDialogFragment!!.setText(msg)
    } else {
      progressDialogFragment = ProgressDialogFragment.newInstance(msg)
      progressDialogFragment!!.show(supportFragmentManager, "PROGRESS")
    }
  }

  fun hideProgress() {
    progressDialogFragment?.dismiss()
  }

}
