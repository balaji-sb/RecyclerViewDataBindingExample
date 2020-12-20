package com.pb.pbdatabinding

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Created by balaji on 20/12/20 6:06 PM
 */


@BindingAdapter("userName")
fun TextView.setUserName(user: User) {
    text = user.userName
}
