package com.shyampanchal.lendify.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.shyampanchal.lendify.R
import com.shyampanchal.lendify.utils.DateUtils
import com.shyampanchal.lendify.viewmodels.HomeViewModel
import com.shyampanchal.lendify.views.itemView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val vm = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        vm.itemsList.observe(this, Observer { itemsList ->
            loading_progress.visibility = View.GONE
            items_list.buildModelsWith {
                it.apply {
                    var idValue = 0
                    itemsList
                        .filterNotNull()
                        .forEach {
                            itemView {
                                id(idValue)
                                name(it.itemName)
                                val startDate = DateUtils.convertUnixToDate(it.startTime)
                                startTime(DateUtils.getFormattedDateText(startDate))
                                val endDate = DateUtils.convertUnixToDate(it.endTime)
                                endTime(DateUtils.getFormattedDateText(endDate))
                                idValue++
                            }
                        }
                }
            }
        })
    }
}