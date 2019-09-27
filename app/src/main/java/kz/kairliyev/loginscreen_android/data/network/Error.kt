package kz.kairliyev.loginscreen_android.data.network

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("error") val error: String?,
    @SerializedName("message") val message: String?
)