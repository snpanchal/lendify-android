package com.shyampanchal.lendify.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.shyampanchal.lendify.R
import com.shyampanchal.lendify.utils.DateUtils
import com.shyampanchal.lendify.viewmodels.HomeViewModel
import com.shyampanchal.lendify.views.itemView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (auth.currentUser == null) {
            startActivity(LoginActivity.newIntent(this))
        }

        val vm = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        vm.itemsList.observe(this, Observer { itemsList ->
            loading_progress.visibility = View.GONE
            items_list.buildModelsWith {
                it.apply {
                    var idValue = 0
                    itemsList
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_sign_out -> {
                auth.signOut()
                startActivity(RegisterActivity.newIntent(this))
            }
        }
        return true
    }

    companion object {
        fun newIntent(context: Context) =
            Intent(context, HomeActivity::class.java)
    }
}
