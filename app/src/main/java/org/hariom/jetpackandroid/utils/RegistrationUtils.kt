package org.hariom.jetpackandroid.utils

object RegistrationUtils {

    private val existingUser = listOf("Hemant", "Dhimahi", "Hariom")

    /**
     * the input is not valid if...
     * ...the username/password empty
     * ...the username already taken
     * ...the confirm password is not the same as the real password
     * ...the password contain less than 2 digit
     */
    fun validateRegistrationInput(
        userName: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (userName.isEmpty() || password.isEmpty()) {
            return false
        }
        if (userName in existingUser) {
            return false
        }
        if (password != confirmPassword) {
            return false
        }
        if (password.count {
                it.isDigit() } < 2){
            return false
        }
        return true

    }
}