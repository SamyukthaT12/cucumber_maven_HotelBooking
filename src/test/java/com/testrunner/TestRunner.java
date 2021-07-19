package com.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber.json"},features="Feature",glue= {"step_definition"},tags= {"@HotelBooking"},junit="--step-notifications")
public class TestRunner {

}
