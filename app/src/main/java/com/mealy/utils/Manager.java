package com.mealy.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.mealy.MealListFragment;
import com.mealy.data.Meal;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    //Data management
    private static Manager _instance;
    private Context _context;
    private XmlManager _xmlManager;
    private ArrayList<Meal> _meals;
    private MealListAdapter _mealListAdapter;
    //Parameters to manage
    private boolean _isEditing;
    private int _mealIndex;
    //UI elements to manage
    private ListView _mealListView;
    private MealListFragment _mealListFragment;

    private Manager() {
        //getXmlManager().loadMeals();
    }

    //FUNCTIONS
    public void setListScrollable(boolean scrollable){
        //_mealListView.set
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

    public MealListAdapter getMealListAdapter() {
        return _mealListAdapter;
    }

    public void setMealListAdapter(MealListAdapter mealListAdapter) {
        this._mealListAdapter = mealListAdapter;
    }

    public int getMealIndex() {
        return _mealIndex;
    }

    public void setMealIndex(int mealIndex) {
        this._mealIndex = mealIndex;
    }

    public boolean isEditing() { return _isEditing; }

    public void setIsEditing(boolean isEditing) { this._isEditing = isEditing; }

    public void setMealListView(ListView mealListView) {
        this._mealListView = mealListView;
    }

    public MealListFragment getMealListFragment() {
        return _mealListFragment;
    }

    public void setMealListFragment(MealListFragment mealListFragment) {
        this._mealListFragment = mealListFragment;
    }
}
