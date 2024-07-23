package com.example.bddtestingwithcucumbergherkinespressoselenium.steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.example.bddtestingwithcucumbergherkinespressoselenium.MainActivity;
import com.example.bddtestingwithcucumbergherkinespressoselenium.R;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ToDoListSteps {

    private AndroidDriver driver;

    //@BeforeAll (JUnit 5): Runs once before all scenarios in a feature file.
    //@Before (Cucumber): Runs before each scenario.

    @BeforeAll
    public void setupSelenium(){
        try {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Your Device Name or Emulator Name");
        caps.setCapability(MobileCapabilityType.APP, "path/to/your/app.apk"); // Or package name

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("the app is open")
    public void theAppIsOpen() {
        // Launch the app using Espresso
    }

    @When("I enter {string} as a task")
    public void iEnterAsATask(String task) {

        driver.findElement(By.id("task_input")).sendKeys(task);
    }

    @And("I tap the \"Add\" button")
    public void iTapTheAddButton() {
        driver.findElement(By.id("add_button")).click();
    }

    @Then("the task {string} should be displayed in the list")
    public void theTaskShouldBeDisplayedInTheList(String task) {
        WebElement editText = driver.findElement(By.id("task_edittext_id"));
        String actualTask = editText.getText();
        Assert.assertEquals("Task text in EditText does not match", task, actualTask);
    }

}
