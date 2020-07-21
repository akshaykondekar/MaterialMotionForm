package com.core.materialmotionform

import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView

@BindingAdapter("status")
fun setStatus(materialTextView : MaterialTextView, status : Boolean){
    when {
        status -> {
            materialTextView.apply {
                text = context.getString(R.string.issued)
                setTextColor(context.getColor(R.color.issued))
            }
        }
        else -> {
            materialTextView.apply {
                text = context.getString(R.string.pending)
                setTextColor(context.getColor(R.color.pending))
            }
        }
    }
}
