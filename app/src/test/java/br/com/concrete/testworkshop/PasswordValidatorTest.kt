package br.com.concrete.testworkshop

import br.com.concrete.testworkshop.util.PasswordValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()

    @Test
    fun givenPasswordWithMinimumRequirements_whenValidate_shouldReturnTrue() {
        // Arrange
        val password = "Senha&123"
        // Act
        val result = passwordValidator.isValid(password)
        // Assert
        assertTrue(result)
    }

    @Test
    fun givenPasswordWithLessThanEightCharacters_whenValidate_shouldReturnFalse() {
        // Arrange
        val password = "1234567"
        // Act
        val result = passwordValidator.hasMinimum8Characters(password)
        // Assert
        assertFalse(result)
    }


    @Test
    fun givenPasswordWithMoreThanEightCharacters_whenValidate_shouldReturnTrue() {
        // Arrange
        val password = "12345678"
        // Act
        val result = passwordValidator.hasMinimum8Characters(password)
        // Assert
        assertTrue(result)
    }

    @Test
    fun givenPasswordWithoutUppercaseLetter_WhenValidate_shouldReturnFalse() {
        // Arrange
        val password = "adjsdx"
        // Act
        val result = passwordValidator.hasUppercaseLetter(password)
        // Assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithUppercaseLetter_WhenValidate_shouldReturnTrue() {
        // Arrange
        val password = "ABxcs"
        // Act
        val result = passwordValidator.hasUppercaseLetter(password)
        // Assert
        assertTrue(result)
    }

    @Test
    fun givenPasswordWithoutLowercaseLetter_WhenValidate_shouldReturnFalse() {
        // Arrange
        val password = "SENHA&123"
        // Act
        val result = passwordValidator.hasLowercaseLetter(password)
        // Assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithLowercaseLetter_WhenValidate_shouldReturnTrue() {
        // Arrange
        val password = "senha&123"
        // Act
        val result = passwordValidator.hasLowercaseLetter(password)
        // Assert
        assertTrue(result)
    }

    @Test
    fun givenPasswordWithoutNumber_WhenValidate_shouldReturnFalse() {
        // Arrange
        val password = "abcd$("
        // Act
        val result = passwordValidator.hasNumber(password)
        // Assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithNumber_WhenValidate_shouldReturnTrue() {
        // Arrange
        val password = "32idljks"
        // Act
        val result = passwordValidator.hasNumber(password)
        // Assert
        assertTrue(result)
    }

    @Test
    fun givenPasswordWithoutSpecialCharacter_WhenValidate_shouldReturnFalse() {
        // Arrange
        val password = "aBCJKA93"
        // Act
        val result = passwordValidator.hasSpecialCharacter(password)
        // Assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordWithSpecialCharacter_WhenValidate_shouldReturnTrue() {
        // Arrange
        val password = "#$32"
        // Act
        val result = passwordValidator.hasSpecialCharacter(password)
        // Assert
        assertTrue(result)
    }
}