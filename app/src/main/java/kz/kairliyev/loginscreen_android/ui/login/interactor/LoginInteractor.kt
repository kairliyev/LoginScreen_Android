package kz.kairliyev.loginscreen_android.ui.login.interactor

import io.reactivex.Observable
import io.reactivex.Single
import kz.kairliyev.loginscreen_android.data.network.ApiHelper
import kz.kairliyev.loginscreen_android.data.network.LoginResponse
import kz.kairliyev.loginscreen_android.data.preferences.PreferenceHelper
import kz.kairliyev.loginscreen_android.ui.base.interactor.BaseInteractor
import kz.kairliyev.loginscreen_android.util.AppConstants
import javax.inject.Inject


class LoginInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) :
    BaseInteractor(preferenceHelper, apiHelper), LoginAppInteractor {

    override fun doServerLoginApiCall(email: String, password: String): Single<LoginResponse> {
        return apiHelper.performServerLogin()
    }

    private fun createQueryMap(login: String, password: String): Map<String, String> {
        return hashMapOf("email" to login, "password" to password)
    }

    private fun doLogOut(){

    }

    override fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) =
        preferenceHelper.let {
            it.setCurrentUserId(loginResponse.userId)
            it.setAccessToken(loginResponse.accessToken)
            it.setCurrentUserLoggedInMode(loggedInMode)
        }
}