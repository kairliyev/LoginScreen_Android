package kz.kairliyev.loginscreen_android.data.strategy

import retrofit2.HttpException


interface OkHttpStatusStrategy {
    fun onHttpStatusCode(httpCode: HttpException)
}