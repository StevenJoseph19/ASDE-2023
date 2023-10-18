package com.newfeatures.java17;

import com.newfeatures.java17.nonsealed.Apple;
import com.newfeatures.java17.nonsealed.Fruit;
import com.newfeatures.java17.nonsealed.Pear;
import com.newfeatures.java17.sealed.AppleSealed;
import com.newfeatures.java17.sealed.FruitSealed;
import com.newfeatures.java17.sealed.PearSealed;

public class SealedClasses {

    public static void main(String[] args) {

    }

    private static void problemSpace() {
        Apple apple = new Apple();
        Pear pear = new Pear();
        Fruit fruit = apple;
        class Avocado extends Fruit {};
    }

    private static void sealedClasses() {
        AppleSealed apple = new AppleSealed();
        PearSealed pear = new PearSealed();
        FruitSealed fruit = apple;
        class Avocado extends AppleSealed {};
    }

}
