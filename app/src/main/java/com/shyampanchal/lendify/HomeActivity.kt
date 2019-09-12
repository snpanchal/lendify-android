package com.shyampanchal.lendify

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.shyampanchal.lendify.viewmodels.HomeViewModel
import com.shyampanchal.lendify.views.itemView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val vm = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        vm.itemsList.observe(this, Observer { itemsList ->
            items_list.buildModelsWith {
                it.apply {
                    var idValue = 0
                    itemsList
                        .filterNotNull()
                        .forEach {
                        itemView {
                            id(idValue)
                            name(it.itemName)
                            key1(it.key1)
                            key2(it.key2)
                            idValue++
                        }
                    }
                }
            }
        })
    }
}
