package com.acme.bdd;

public class CalculatorStepDefinitions {
    @Given("I have a calculator")
    public void i_have_a_calculator() {
     
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should get {int}")
    public void i_should_get(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
