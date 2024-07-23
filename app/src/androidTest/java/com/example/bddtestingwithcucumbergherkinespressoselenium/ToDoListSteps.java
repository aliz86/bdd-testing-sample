package com.example.bddtestingwithcucumbergherkinespressoselenium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.espresso.matcher.ViewMatchers;

import com.example.bddtestingwithcucumbergherkinespressoselenium.MainActivity;
import com.example.bddtestingwithcucumbergherkinespressoselenium.R;

import org.junit.Rule;

public class ToDoListSteps {
    /*@Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);
*/
    @Given("the app is open")
    public void theAppIsOpen() {
        // Launch the app using Espresso
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
