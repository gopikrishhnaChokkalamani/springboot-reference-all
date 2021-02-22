package com.springboot;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/",
        glue = { "com.springboot.cucumber.steps" },
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber-reports.json",
                "junit:target/site/cucumber_junit_report.xml"})
public class CucumberRunner {
}
