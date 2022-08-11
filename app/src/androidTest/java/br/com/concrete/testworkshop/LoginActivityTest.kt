package br.com.concrete.testworkshop

import android.app.Activity
import android.app.Instrumentation
import android.app.Instrumentation.ActivityResult
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityScenario = ActivityScenarioRule(LoginActivity::class.java)

    private val validEmail = "w.jonathan.marcolino@accenture.com"
    private val validPassword = "Senha@123"
    private val invalidPassword = "123"

    @Before
    fun setup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

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
            .perform(typeText(validPassword))
        onView(withId(R.id.buttonLogin))
            .perform(click())

        // Assert
        onView(withText(R.string.error_empty_email))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenEmptyPassword_whenLogin_shouldShowEmptyPasswordError() {
        // Arrange

        // Act
        onView(withId(R.id.email))
            .perform(typeText(validEmail))
        onView(withId(R.id.buttonLogin))
            .perform(click())

        // Assert
        onView(withText(R.string.error_empty_password))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenInvalidPassword_whenLogin_shouldShowInvalidPasswordErrorMessage() {
        // Arrange

        // Act
        onView(withId(R.id.email))
            .perform(typeText(validEmail))
        onView(withId(R.id.password))
            .perform(typeText(invalidPassword))
        onView(withId(R.id.buttonLogin))
            .perform(click())

        // Assert
        onView(withText(R.string.error_invalid_password))
            .check(matches(isDisplayed()))
    }


    @Test
    fun givenValidEmailAndPassword_whenLogin_shouldGoToHomescreen() {
        // Arrange
        intending(hasComponent(HomeActivity::class.java.name))
            .respondWith(ActivityResult(Activity.RESULT_CANCELED, null))

        // Act
        onView(withId(R.id.email))
            .perform(typeText(validEmail))
        onView(withId(R.id.password))
            .perform(typeText(validPassword))
        onView(withId(R.id.buttonLogin))
            .perform(click())

        // Assert
        intended(hasComponent(HomeActivity::class.java.name))
    }

}