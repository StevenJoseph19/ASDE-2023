package com.acme.bdd.loyalty_cards;

import java.util.HashMap;
import java.util.Map;

public class DrinkCatalog {

    Map<String, String> drinkCategories = new HashMap<>();

    public void addDrink(String drink, String category) {
        drinkCategories.put(drink, category);
    }

    public String getCategoryOf(String drink) {
        return drinkCategories.get(drink);
    }
}
