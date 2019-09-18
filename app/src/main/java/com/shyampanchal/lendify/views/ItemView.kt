package com.shyampanchal.lendify.views

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.shyampanchal.lendify.R
import kotlinx.android.synthetic.main.item_view.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ItemView(context: Context) : ConstraintLayout(context) {

    init {
        View.inflate(context, R.layout.item_view, this)
    }

    @TextProp
    fun name(name: CharSequence) {
        item_name.text = name
    }

    @TextProp
    fun startTime(startTime: CharSequence) {
        item_start_time.text = startTime
    }

    @TextProp
    fun endTime(endTime: CharSequence) {
        item_end_time.text = endTime
    }
}