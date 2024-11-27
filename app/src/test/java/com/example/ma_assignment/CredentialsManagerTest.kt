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

    // Given proper credentials, when user registers, then create a new account
    @Test
    fun isProperCredentials_whenUserRegisters_thenCreateAccount(){
        val email = "another@te.st"
        val password = "123456qwerty"

        val credentialsManager = CredentialsManager()

        credentialsManager.register("Full name", email, "600 600 600", password)

        val isLoginSuccess = credentialsManager.login(email, password)
        assertTrue(isLoginSuccess)
    }
    // Given already used email, =||=, then return error
    // Given already used email with different casing, =||=, =||=
    // Given already used email with different casing, when user logs in, then return success

}