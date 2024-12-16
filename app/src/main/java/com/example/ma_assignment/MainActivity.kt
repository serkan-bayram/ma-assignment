package com.example.ma_assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragmentContainer, SignInFragment.newInstance(credentialsManager))
            }
        }
    }

    fun navigateToRegister() {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, RegisterFragment.newInstance(credentialsManager))
            addToBackStack(null)
        }
    }

    fun navigateToSignIn() {
        supportFragmentManager.popBackStack()
    }
}
