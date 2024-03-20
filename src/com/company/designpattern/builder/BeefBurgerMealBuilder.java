package com.company.designpattern.builder;

/**
 * @author Administrator
 */
public class BeefBurgerMealBuilder extends MealBuilder {

    @Override
    public void buildBurger() {
        meal.setBurger("牛肉汉堡");
    }

    @Override
    public void buildFries() {
        meal.setFries("大份薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("中杯可乐");
    }
}
