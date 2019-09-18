package com.shyampanchal.lendify.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.shyampanchal.lendify.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        login_button.setOnClickListener {
            startActivity(LoginActivity.newIntent(this))
        }

        sign_up_button.setOnClickListener {
            val email = register_email.editText?.text.toString()
            val password = register_password.editText?.text.toString()

            if (email.trim().isNotEmpty() && password.trim().isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    register_error.isGone = task.isSuccessful
                    if (task.isSuccessful) {
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
