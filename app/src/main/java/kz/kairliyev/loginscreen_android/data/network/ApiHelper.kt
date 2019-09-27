package kz.kairliyev.loginscreen_android.data.network

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface ApiHelper {

    @GET("588d15f5100000a8072d2945")
    fun performServerLogin(): Single<LoginResponse>
}