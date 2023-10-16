package com.acme.bdd.loyalty_cards;

public class MorningFreshnessMember {
    private String name;
    private SuperSmoothieSchema schema;
    private int points;

    public MorningFreshnessMember(String name, SuperSmoothieSchema schema) {
        this.name = name;
        this.schema = schema;
    }

    public void orders(Integer amount, String drink) {
        points += schema.getPointsFor(drink) * amount;
    }

    public int getPoints() {
        return points;
    }
}
