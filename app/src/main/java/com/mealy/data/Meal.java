package com.mealy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Meal implements Serializable {
    private String _title;
    private List<Ingredient> _ingredients;
    private List<String> _instruction;

    public Meal() {

    }

    public Meal(String title) {
        setTitle(title);
    }

    public Meal(String title, List<Ingredient> ingredients, List<String> instructions) {
        setTitle(title);
        setIngredients(ingredients);
        setInstructions(instructions);
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
    public List<String> getInstructions() {
        if(_instruction == null){ _instruction = new ArrayList<String>(); }
        return _instruction;
    }
    public void setInstructions(List<String> instructions) {
        this._instruction = instructions;
    }
}
