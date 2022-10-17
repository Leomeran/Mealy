package com.mealy.data;

import java.util.ArrayList;
import java.util.List;

public class MealList {
    private List<Meal> _mealList;

    //GETTERS AND SETTERS
    public List<Meal> getMealList() {
        if(_mealList == null){ _mealList = new ArrayList<Meal>(); }
        return _mealList;
    }
    public void setMealList(List<Meal> mealList) {
        this._mealList = mealList;
    }

    public int getSize(){
        return getMealList().size();
    }
    public void addMeal(Meal meal){
        getMealList().add(meal);
    }
}
