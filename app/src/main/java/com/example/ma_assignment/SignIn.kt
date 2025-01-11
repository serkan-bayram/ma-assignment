package com.example.ma_assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignInFragment(private val credentialsManager: CredentialsManager) : Fragment() {

    companion object {
        fun newInstance(credentialsManager: CredentialsManager) = SignInFragment(credentialsManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val emailInputLayout: TextInputLayout = view.findViewById(R.id.emailInputLayout)
        val emailInputField: TextInputEditText = view.findViewById(R.id.emailInput)
        val passwordInputLayout: TextInputLayout = view.findViewById(R.id.passwordInputLayout)
        val passwordInputField: TextInputEditText = view.findViewById(R.id.passwordInput)
        val nextButton: Button = view.findViewById(R.id.nextButton)
        val registerNowTextView: TextView = view.findViewById(R.id.registerNowText)

        nextButton.setOnClickListener {
            val email = emailInputField.text.toString()
            val password = passwordInputField.text.toString()

            val isEmailValid = credentialsManager.isEmailValid(email)
            val isPasswordValid = credentialsManager.isPasswordValid(password)

            if (!isEmailValid) {
                emailInputLayout.error = "Invalid email!"
            } else {
                emailInputLayout.error = null
            }

            if (!isPasswordValid) {
                passwordInputLayout.error = "Invalid password!"
            } else {
                passwordInputLayout.error = null
            }

            if (isEmailValid && isPasswordValid) {
                if (credentialsManager.login(email, password)) {
                    // Handle successful login
                } else {
                    passwordInputLayout.error = "Incorrect credentials!"
                }
            }
        }

        //registerNowTextView.setOnClickListener {
        //    (activity as? MainActivity)?.navigateToRegister()
        //}

        return view
    }
}
