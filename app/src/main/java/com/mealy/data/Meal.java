package com.mealy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Meal implements Serializable {
    private String _title;
    private List<Ingredient> _ingredients;
    private List<String> _steps;

    public Meal() {

    }

    public Meal(String title, List<Ingredient> ingredients, List<String> steps) {
        setTitle(title);
        setIngredients(ingredients);
        setSteps(steps);
    }

    //GETTERS AND SETTERS
    public String getTitle() {
        return _title;
    }
    public void setTitle(String title) {
        this._title = title;
    }
    public List<Ingredient> getIngredients() {
        if(_ingredients == null){ _ingredients = new ArrayList<Ingredient>(); }
        return _ingredients;
    }
    public void setIngredients(List<Ingredient> ingredients) {
        this._ingredients = ingredients;
    }
    public List<String> getSteps() {
        if(_steps == null){ _steps = new ArrayList<String>(); }
        return _steps;
    }
    public void setSteps(List<String> steps) {
        this._steps = steps;
    }
}
