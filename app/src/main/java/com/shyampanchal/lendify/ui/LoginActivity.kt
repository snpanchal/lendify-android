package com.shyampanchal.lendify.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import com.shyampanchal.lendify.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        register_button.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }

        sign_up_button.setOnClickListener {
            val email = login_email.editText?.text.toString()
            val password = login_password.editText?.text.toString()

            if (email.trim().isNotEmpty() && password.trim().isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        login_error.isGone = task.isSuccessful
                        if (task.isSuccessful) {
                            startActivity(HomeActivity.newIntent(this))
                        }
                    }
            }
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}
