package kz.kairliyev.loginscreen_android.util.extension

import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import kz.kairliyev.loginscreen_android.R

internal fun FragmentManager.removeFragment(tag: String) {
    this.findFragmentByTag(tag)?.let {
        this.beginTransaction()
            .disallowAddToBackStack()
            .remove(it)
            .commitNow()
    }
}

internal fun FragmentManager.addFragment(containerViewId: Int,
                                         fragment: Fragment,
                                         tag: String) {
    this.beginTransaction().disallowAddToBackStack()
            .add(containerViewId, fragment, tag)
            .commit()
}

