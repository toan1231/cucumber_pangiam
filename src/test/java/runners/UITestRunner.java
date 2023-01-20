package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber",
        "json:target/cucumber.json"},
        features="src/test/resources/uiFeatures",
        glue="ui_automation.step_definitions",
        tags="@toan",//remember to take off 1
        dryRun =false
        //monochrome = true
)

public class UITestRunner {

}

/*
to have : cucumber-html-reports click terminal then type ://if having something there
you should type: clear or cls , enter
mvn "-Dtest=runners.UITestRunner" verify
mvn -"Dtest=runners.UITestRunner" verify -DBrowser="edge"
if you want to clear up the console type clear then enter
BIG NOTE: TO RUN THE NEW ONE YOU MUST CLOSE THE (Localx) next to Terminal
on left botton down here
try luck mvn clear,mnv clean,clear,clean....
I click type clear enter , then (mvn "-Dtest=runners.UITestRunner" verify)
TO REPORT ALL FEATURES:  we use same tag name like @wip or any tag and attach to all
feature file . meaning use same tag for all and urun will run all classes
if you want to run in firefox or edge you change like this
mvn -"Dtest=runners.UITestRunner" verify -DBrowser="edge"(but I don't know why it not working
you need to veriry,
to run in parallele you need to put tag in two location in feature file and change threat to 2, if you
want 3 thread you change to 3 and put tag in 3 location I think



 */