package com.example.ma_assignment


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class SignInActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()
    private val registerNowLabel: TextView
        get() = findViewById(R.id.registerNowText)

    private val nextButton: Button
        get() = findViewById(R.id.nextButton)

    private val emailInputLayout: TextInputLayout
        get() = findViewById(R.id.emailInputLayout)

    private val emailInputField: TextInputEditText
        get() = findViewById(R.id.emailInput)

    private val passwordInputLayout: TextInputLayout
        get() = findViewById(R.id.passwordInputLayout)

    private val passwordInputField: TextInputEditText
        get() = findViewById(R.id.passwordInput)

    private val email: String
        get() = emailInputLayout.editText?.text?.toString().orEmpty()

    private val password: String
        get() = passwordInputLayout.editText?.text?.toString().orEmpty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val registerNowTextView = findViewById<TextView>(R.id.registerNowText)

        registerNowTextView.setOnClickListener { v: View? ->
            val intent = Intent(
                this,
                RegisterActivity::class.java
            )
            startActivity(intent)
        }

        nextButton.setOnClickListener {
            val email = emailInputField.text.toString()
            val password = passwordInputField.text.toString()

            val isEmailValid = CredentialsManager().isEmailValid(email)
            val isPasswordValid = CredentialsManager().isPasswordValid(password)

            if (!isEmailValid) {
                emailInputLayout.isErrorEnabled = true
                emailInputLayout.error = "Email is invalid!"
            }
            else
            {
                emailInputLayout.isErrorEnabled = false
            }

            if (!isPasswordValid) {
                passwordInputLayout.isErrorEnabled = true
                passwordInputLayout.error = "Password is invalid!"
            }
            else
            {
                passwordInputLayout.isErrorEnabled = false
            }

        }
    }
}