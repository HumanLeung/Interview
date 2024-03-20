package com.company.designpattern.builder;

/**
 * @author Administrator
 */
public class MealDirector {
    private MealBuilder mealBuilder;
    public void setMealBuilder(MealBuilder mealBuilder){
        this.mealBuilder=mealBuilder;
    }

    public Meal getMeal(){
        return mealBuilder.getMeal();
    }

    public void constructMeal(){
        mealBuilder.buildBurger();
        mealBuilder.buildFries();
        mealBuilder.buildDrink();
    }


}
