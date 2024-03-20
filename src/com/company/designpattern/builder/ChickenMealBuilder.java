package com.company.designpattern.builder;

/**
 * @author Administrator
 */
public class ChickenMealBuilder extends MealBuilder{
    @Override
    public void buildBurger() {
       meal.setBurger("鸡肉汉堡");
    }

    @Override
    public void buildFries() {
      meal.setFries("中份薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("大杯果汁");
    }
}
