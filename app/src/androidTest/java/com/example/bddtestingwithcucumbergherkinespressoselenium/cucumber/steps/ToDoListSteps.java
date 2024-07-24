package com.example.bddtestingwithcucumbergherkinespressoselenium.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.bddtestingwithcucumbergherkinespressoselenium.MainActivity;
import com.example.bddtestingwithcucumbergherkinespressoselenium.R;

import org.junit.Rule;

public class ToDoListSteps {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Given("the app is open")
    public void theAppIsOpen() {
        System.out.println("Test is running");
        // Launch the app using Espresso's Intents
        //TODO:  wrong: it executes the app every time. must only check app being open and if NOT open, open it.
        Intent intent = new Intent(InstrumentationRegistry.getInstrumentation().getTargetContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // Ensure a fresh start
        InstrumentationRegistry.getInstrumentation().startActivitySync(intent);
    }

    @When("I enter {string} as a task")
    public void iEnterAsATask(String task) {
        onView(ViewMatchers.withId(R.id.task_input)).perform(typeText(task));
    }

    @And("I tap the \"Add\" button")
    public void iTapTheAddButton() {
        onView(withId(R.id.add_button)).perform(click());
    }

    @Then("the task {string} should be displayed in the list")
    public void theTaskShouldBeDisplayedInTheList(String task) {
        onView(withText(task)).check(matches(isDisplayed()));
    }

}
