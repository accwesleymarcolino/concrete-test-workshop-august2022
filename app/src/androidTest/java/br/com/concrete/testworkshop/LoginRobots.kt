package br.com.concrete.testworkshop

import android.app.Activity
import android.app.Instrumentation
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers

class loginArrange(action: loginArrange.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun mockHomeActivityResponse() {
        Intents.intending(IntentMatchers.hasComponent(HomeActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
    }
}

class loginAct(action: loginAct.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun typeEmail(email: String) {
        Espresso.onView(ViewMatchers.withId(R.id.email))
            .perform(ViewActions.typeText(email))
    }

    fun typePassword(password: String) {
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.typeText(password))
    }

    fun clickLogin() {
        Espresso.onView(ViewMatchers.withId(R.id.buttonLogin))
            .perform(ViewActions.click())
    }
}

class loginAssert(action: loginAssert.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun homeActivityWasCalled() {
        Intents.intended(IntentMatchers.hasComponent(HomeActivity::class.java.name))
    }

    fun textIsShownToTheUser(@StringRes textRes: Int) {
        Espresso.onView(ViewMatchers.withText(textRes))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun fieldIsEmpty(fieldId: Int) {
        Espresso.onView(ViewMatchers.withId(fieldId))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }
}