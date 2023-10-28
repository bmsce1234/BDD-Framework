package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/Feature1.Feature"},
				 glue = {"gluecode"}
				 ,monochrome = true,
				  plugin = {"preety"})
public class Runner {

}