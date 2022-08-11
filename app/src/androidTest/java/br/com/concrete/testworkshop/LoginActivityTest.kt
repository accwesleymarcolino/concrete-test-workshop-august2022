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
        loginAssert {
            fieldIsEmpty(R.id.email)
            fieldIsEmpty(R.id.password)
        }
    }

    @Test
    fun givenEmptyEmail_whenLogin_shouldShowEmptyEmailError() {
        loginAct {
            typePassword(validPassword)
            clickLogin()
        }

        loginAssert {
            textIsShownToTheUser(R.string.error_empty_email)
        }
    }

    @Test
    fun givenEmptyPassword_whenLogin_shouldShowEmptyPasswordError() {
        loginAct {
            typeEmail(validEmail)

            clickLogin()
        }

        loginAssert {
            textIsShownToTheUser(R.string.error_empty_password)
        }
    }

    @Test
    fun givenInvalidPassword_whenLogin_shouldShowInvalidPasswordErrorMessage() {
        loginAct {
            typeEmail(validEmail)
            typePassword(invalidPassword)

            clickLogin()
        }

        loginAssert {
            textIsShownToTheUser(R.string.error_invalid_password)
        }
    }

    @Test
    fun givenValidEmailAndPassword_whenLogin_shouldGoToHomescreen() {
        loginArrange {
            mockHomeActivityResponse()
        }

        loginAct {
            typeEmail(validEmail)
            typePassword(validPassword)

            clickLogin()
        }

        loginAssert {
            homeActivityWasCalled()
        }
    }

}