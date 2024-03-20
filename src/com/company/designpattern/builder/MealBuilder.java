package com.company.designpattern.builder;

/**
 * @author Administrator
 */
public abstract class MealBuilder {
    protected Meal meal = new Meal();

    /**
     * 构建汉堡
     */
    public abstract void buildBurger();

    /**
     * 构建薯条
     */
    public abstract void buildFries();

    /**
     * 构建饮料
     */
    public abstract void buildDrink();

    public Meal getMeal(){
        return meal;
    }
}
