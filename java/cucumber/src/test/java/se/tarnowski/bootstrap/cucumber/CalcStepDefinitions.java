package se.tarnowski.bootstrap.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class CalcStepDefinitions {

    private int addend;
    private int augend;
    private int actualResult;

    @Given("the addend is (\\d+)")
    public void setAddend(int addend) {
        this.addend = addend;
    }

    @And("the augend is (\\d+)")
    public void setAugend(int augend) {
        this.augend = augend;
    }

    @When("(\\w+) is applied")
    public void setOperator(String operator) {
        if ("plus".equals(operator)) {
            actualResult = addend + augend;
        }
    }

    @Then("the result is (\\d+)")
    public void computeResult(int expectedResult) {
        assertEquals(expectedResult, actualResult);
    }
}
