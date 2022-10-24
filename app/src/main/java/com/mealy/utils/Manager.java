package com.mealy.utils;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.mealy.data.Meal;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static Manager _instance;
    private Context _context;
    private XmlManager _xmlManager;
    private ArrayList<Meal> _meals;

    private boolean _isEditing;

    private int _mealIndex;

    private Manager() {
        //getXmlManager().loadMeals();
    }

    //GETTERS AND SETTERS
    public static Manager getInstance() {
        if(_instance == null){ _instance = new Manager(); }
        return _instance;
    }

    public Context getContext() { return _context; }
    public void setContext(Context context) { this._context = context; }

    public XmlManager getXmlManager() {
        if(_xmlManager == null){ _xmlManager = new XmlManager(); }
        return _xmlManager;
    }
    public void setXmlManager(XmlManager xmlManager) { this._xmlManager = xmlManager; }

    public ArrayList<Meal> getMeals() {
        if(_meals == null){ _meals = new ArrayList<Meal>(); }
        return _meals;
    }
    public void setMeals(ArrayList<Meal> meals) { this._meals = meals; }

    public int getMealIndex() {
        return _mealIndex;
    }

    public void setMealIndex(int mealIndex) {
        this._mealIndex = mealIndex;
    }

    public boolean isEditing() { return _isEditing; }

    public void setIsEditing(boolean isEditing) { this._isEditing = isEditing; }
}
