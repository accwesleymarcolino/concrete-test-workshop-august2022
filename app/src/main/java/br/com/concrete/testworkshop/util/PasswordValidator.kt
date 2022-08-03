package br.com.concrete.testworkshop.util

class PasswordValidator {
    fun isValid(password: String): Boolean {
        return password.length > 8
    }
}
