package com.example.ma_assignment

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsManagerTest {

    @Test
    fun isEmailEmpty_thenReturnFalse(){
        val credentialsManager = CredentialsManager()

        assertEquals(false, credentialsManager.isEmailValid(""))
    }

    @Test
    fun isEmailValid_thenReturnTrue(){
        val credentialsManager = CredentialsManager()

        assertEquals(true, credentialsManager.isEmailValid("hello@gmail.com"))
    }

    @Test
    fun isEmailInvalid_thenReturnFalse(){
        val credentialsManager = CredentialsManager()

        assertEquals(false, credentialsManager.isEmailValid("not_a_real_email"))
    }

    @Test
    fun isPasswordEmpty_thenReturnFalse(){
        val credentialsManager = CredentialsManager()

        assertEquals(false, credentialsManager.isPasswordValid(""))
    }

    @Test
    fun isPasswordNotEmpty_thenReturnTrue(){
        val credentialsManager = CredentialsManager()

        assertEquals(true, credentialsManager.isPasswordValid("not_empty"))
    }

    @Test
    fun isWrongCredentials_thenReturnFalse(){
        val credentialsManager = CredentialsManager()
        val email = "wrongEmail"
        val password = ""

        val result = credentialsManager.login(email, password)

        assertEquals(false, result)
    }

}