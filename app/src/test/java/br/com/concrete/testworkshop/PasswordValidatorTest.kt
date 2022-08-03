package br.com.concrete.testworkshop

import br.com.concrete.testworkshop.util.PasswordValidator
import org.junit.Assert.assertFalse
import org.junit.Test

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()

    @Test
    fun givenPasswordIsShorterThan8_whenValidate_shouldReturnFalse() {
        // Arrange
        val password = "123456"

        // Act
        val result = passwordValidator.isValid(password)

        // Assert
        assertFalse(result)
    }
}