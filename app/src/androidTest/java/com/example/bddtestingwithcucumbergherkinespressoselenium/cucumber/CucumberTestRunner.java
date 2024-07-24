package com.example.bddtestingwithcucumbergherkinespressoselenium.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.example.bddtestingwithcucumbergherkinespressoselenium.cucumber.steps"
)
public class CucumberTestRunner {

}
