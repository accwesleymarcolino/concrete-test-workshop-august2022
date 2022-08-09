package br.com.concrete.testworkshop.util

import androidx.annotation.VisibleForTesting

class PasswordValidator {
    private val hasMinimumSizeRegex = "[\\w\\W]{8,}".toRegex()
    private val hasUpperCaseLetterRegex = "[A-Z]".toRegex()
    private val hasLowerCaseLetterRegex = "[a-z]".toRegex()
    private val hasNumberRegex = "\\d".toRegex()
    private val hasSpecialCharacterRegex = "\\W".toRegex()

    fun isValid(password: String): Boolean {
        val hasMinimumCharacters = hasMinimum8Characters(password)
        val hasUppercaseLetter = hasUppercaseLetter(password)
        val hasLowercaseLetter = hasLowercaseLetter(password)
        val hasNumber = hasNumber(password)
        val hasSpecialCharacter = hasSpecialCharacter(password)

        return hasMinimumCharacters
                && hasUppercaseLetter
                && hasLowercaseLetter
                && hasNumber
                && hasSpecialCharacter
    }

    @VisibleForTesting
    fun hasMinimum8Characters(password: String) = password.contains(hasMinimumSizeRegex)

    @VisibleForTesting
    fun hasUppercaseLetter(password: String) = password.contains(hasUpperCaseLetterRegex)

    @VisibleForTesting
    fun hasLowercaseLetter(password: String) = password.contains(hasLowerCaseLetterRegex)

    @VisibleForTesting
    fun hasNumber(password: String) = password.contains(hasNumberRegex)

    @VisibleForTesting
    fun hasSpecialCharacter(password: String) = password.contains(hasSpecialCharacterRegex)

}
