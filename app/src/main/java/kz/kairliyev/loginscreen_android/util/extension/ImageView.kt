package kz.kairliyev.loginscreen_android.util.extension

import android.widget.ImageView
import com.bumptech.glide.Glide


internal fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
            .load(url)
            .asBitmap()
            .centerCrop()
            .into(this)
}