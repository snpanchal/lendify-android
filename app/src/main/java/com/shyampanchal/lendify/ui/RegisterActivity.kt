package com.shyampanchal.lendify.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.shyampanchal.lendify.R
import com.shyampanchal.lendify.models.User
import com.shyampanchal.lendify.viewmodels.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val vm = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        login_button.setOnClickListener {
            startActivity(LoginActivity.newIntent(this))
        }

        sign_up_button.setOnClickListener {
            val username = register_name.editText?.text.toString()
            val email = register_email.editText?.text.toString()
            val password = register_password.editText?.text.toString()
            val phoneNumber = register_phone.editText?.text.toString()

            if (email.trim().isNotEmpty() && password.trim().isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    register_error.isGone = task.isSuccessful
                    if (task.isSuccessful) {
                        val newUser = User(username, email, phoneNumber)
                        vm.addNewUser(newUser)
                        startActivity(HomeActivity.newIntent(this))
                    }
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, RegisterActivity::class.java)
    }
}
