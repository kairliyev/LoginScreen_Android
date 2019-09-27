package kz.kairliyev.loginscreen_android.ui.splash.interactor

import android.content.Context
import kz.kairliyev.loginscreen_android.data.network.ApiHelper
import kz.kairliyev.loginscreen_android.data.preferences.PreferenceHelper
import kz.kairliyev.loginscreen_android.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class SplashInteractor @Inject constructor(private val mContext: Context, preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), SplashAppInteractor


