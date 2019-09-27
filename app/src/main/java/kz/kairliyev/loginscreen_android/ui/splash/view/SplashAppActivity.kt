package kz.kairliyev.loginscreen_android.ui.splash.view

import android.content.Intent
import android.os.Bundle
import kz.kairliyev.loginscreen_android.ui.MainActivity
import kz.kairliyev.loginscreen_android.R
import kz.kairliyev.loginscreen_android.ui.base.view.BaseActivity
import kz.kairliyev.loginscreen_android.ui.login.view.LoginActivity
import kz.kairliyev.loginscreen_android.ui.splash.interactor.SplashAppInteractor
import kz.kairliyev.loginscreen_android.ui.splash.presenter.SplashAppPresenter
import javax.inject.Inject

class SplashAppActivity : BaseActivity(), SplashAppView {

    @Inject
    lateinit var presenter: SplashAppPresenter<SplashAppView, SplashAppInteractor>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onFragmentAttached() {
    }

    override fun showSuccessToast() {
    }

    override fun showErrorToast() {
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
