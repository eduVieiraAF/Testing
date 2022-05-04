package com.example.espressotest

object RegistrationUtil {

    private val existingUsers = listOf("John", "Debby")

    /**
     *  input is not valid if...
     *  ...userName// password is empty
     *  ...userName already taken
     *  ...confirmedPassword != password
     *  ...password < 2 digits
     */

    fun validateRegistrationInput (
        userName: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        if (userName.isEmpty() || password.isEmpty()) return false
        if (userName in existingUsers) return false
        if (password != confirmedPassword) return false
        if (password.count { it.isDigit() }< 2 ) return false

        return true
    }
}