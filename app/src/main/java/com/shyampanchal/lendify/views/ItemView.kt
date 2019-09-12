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
    fun key1(key1: CharSequence) {
        key_1.text = key1
    }

    @TextProp
    fun key2(key2: CharSequence) {
        key_2.text = key2
    }
}