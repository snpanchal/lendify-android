package com.shyampanchal.lendify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.shyampanchal.lendify.viewmodels.HomeViewModel

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }
}
