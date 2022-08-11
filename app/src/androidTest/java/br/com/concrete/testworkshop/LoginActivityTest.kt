package br.com.concrete.testworkshop

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityScenario = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_shouldHaveEmptyEmailAndPassword() {
        // Arrange

        // Act

        // Assert
        onView(withId(R.id.email))
            .check(matches(withText("")))
        onView(withId(R.id.password))
            .check(matches(withText("")))
    }

    @Test
    fun givenEmptyEmail_whenLogin_shouldShowEmptyEmailError() {
        // Arrange

        // Act
        onView(withId(R.id.password))
            .perform(typeText("Senha@123"))
        onView(withId(R.id.buttonLogin))
            .perform(click())

        // Assert
        onView(withText(R.string.error_empty_email))
            .check(matches(isDisplayed()))
    }


}