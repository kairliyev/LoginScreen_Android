package kz.kairliyev.loginscreen_android.ui.base.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import kz.kairliyev.loginscreen_android.data.strategy.Strategy
import retrofit2.HttpException

abstract class BaseActivity : AppCompatActivity(), AppView, BaseFragment.CallBack, Strategy {


    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
    }

    override fun hideProgress() {
    }

    override fun showProgress() {
        hideProgress()
    }

    override fun showToastHttpMessage(error: Throwable) {
        when (error) {
            is HttpException -> onHttpStatusCode(error)
        }
    }

    override fun onHttpStatusCode(httpCode: HttpException) {
        val code = httpCode.code()
        val body = httpCode.code().toString()

        when (code) {
            401 -> onInvalidRequest(body)
            500 -> onInvalidRequest(body)
        }
    }

    private fun onInvalidRequest(obj: String?) {
        Toast.makeText(this, obj, Toast.LENGTH_LONG).show()
    }

    private fun performDI() = AndroidInjection.inject(this)

}