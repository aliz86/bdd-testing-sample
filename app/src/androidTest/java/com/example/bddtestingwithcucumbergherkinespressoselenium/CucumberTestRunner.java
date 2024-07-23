package com.example.bddtestingwithcucumbergherkinespressoselenium;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.bddtestingwithcucumbergherkinespressoselenium.steps"
)
public class CucumberTestRunner {

}
