package com.rohan.movieapp.utils

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter

@BindingAdapter("BindText")
fun TextView.userEdit(input:String) {
    text = "$input"
}
