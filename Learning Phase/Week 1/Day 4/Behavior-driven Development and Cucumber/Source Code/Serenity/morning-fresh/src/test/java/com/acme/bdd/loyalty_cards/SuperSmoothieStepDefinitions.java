package com.acme.bdd.loyalty_cards;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperSmoothieStepDefinitions {

    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    private SuperSmoothieSchema superSmoothieSchema = new SuperSmoothieSchema(drinkCatalog);
    private MorningFreshnessMember michael;

    @Given("the following drink categories:")
    public void the_following_drink_categories(List<Map<String,String>> drinkCategories) {
        drinkCategories.stream().forEach(
                drinkCategory -> {
                    String drink = drinkCategory.get("Drink");
                    String category = drinkCategory.get("Category");
                    Integer points = Integer.parseInt(drinkCategory.get("Points"));

                    drinkCatalog.addDrink(drink, category);
                    superSmoothieSchema.setPointsPerCategory(category, points);

                }
        );
    }

    @Given("^(.*) is a Morning Freshness Member$")
    public void michael_is_a_Morning_Freshness_Member(String name) {
        michael = new MorningFreshnessMember(name, superSmoothieSchema);
    }

    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void michael_purchases_drinks(String name,
                                         Integer amount,
                                         String drink) {
        michael.orders(amount, drink);
    }

    @Then("^s?he should earn (.*) points")
    public void he_should_earn_points(Integer expectedPoints) {
        assertThat(michael.getPoints()).isEqualTo(expectedPoints);
    }


    @Given("{word} has opted for the diet-friendly plan with a maximum flame count of {int}")
    public void has_opted_for_the_diet_friendly_plan_with_a_maximum_flame_count_of(String member, Integer maxFlames) {
        // TODO
    }

    @Given("the following smoothies are available:")
    public void the_following_smoothies_are_available(io.cucumber.datatable.DataTable dataTable) {
        // TODO
    }

    @When("^s?he views the smoothie catalog$")
    public void she_views_the_smoothie_catalog() {
        // TODO
    }

    @Then("^s?he should be shown the following smoothies:")
    public void she_should_be_shown_the_following_smoothies(io.cucumber.datatable.DataTable dataTable) {
        // TODO
    }

    @When("^an? (.*) smoothie contains (.*) calories$")
    public void a_smoothie_contains(String smoothie, Integer calories) {
        // TODO
    }

    @Then("it should be classed as a {int} flame smoothie in the {word} range")
    public void it_should_be_classed_as_a_flame_smoothie(Integer flames, String range) {
        // TODO
    }

}
