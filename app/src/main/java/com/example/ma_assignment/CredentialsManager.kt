package com.example.ma_assignment

import android.util.Patterns

class CredentialsManager {

    val credentialsMap = mutableMapOf(Pair("test", "1234"))

    fun isEmailValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
        val regex = Regex(emailPattern)

        return regex.matches(email)
    }


    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun login(email: String, password: String): Boolean {
        return credentialsMap["email"].equals(password)
    }

    fun register(fullName: String, email: String, phoneNumber: String, password: String) {
        credentialsMap.put(email, password);
    }

}
