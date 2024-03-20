package com.company.designpattern;

import com.company.designpattern.builder.*;

/**
 * @author Administrator
 */
public class TestBuilder {
    public static void main(String[] args) {

        MealDirector director = new MealDirector();
        director.setMealBuilder(new BeefBurgerMealBuilder());
        director.constructMeal();
        Meal meal = director.getMeal();
        System.out.println("牛肉套餐" + meal.toString());

        director.setMealBuilder(new ChickenMealBuilder());
        director.constructMeal();
        Meal meal2 = director.getMeal();
        System.out.println("鸡肉套餐：" + meal2.toString());

        director.setMealBuilder(new ShrimpMealBuilder());
        director.constructMeal();
        Meal meal3 = director.getMeal();
        System.out.println("虾肉套餐："+meal3.toString());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asdqwe");
        stringBuilder.append(1234);
        System.out.println(stringBuilder);
    }
}
