package com.company.designpattern.builder;

/**
 * @author Administrator
 */
public class ShrimpMealBuilder extends MealBuilder {
    @Override
    public void buildBurger() {
        meal.setBurger("虾肉汉堡");
    }

    @Override
    public void buildFries() {
        meal.setFries("小份薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("大杯芬达");
    }

}
