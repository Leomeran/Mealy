package com.mealy.utils;

import android.content.Context;

import com.mealy.data.Meal;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static Manager _instance;
    private Context _context;
    private XmlManager _xmlManager;
    private List<Meal> _meals;

    private Manager() {
        //getXmlManager().loadMeals();
    }

    //GETTERS AND SETTERS
    public static Manager getInstance() {
        if(_instance == null){ _instance = new Manager(); }
        return _instance;
    }

    public Context getContext() {
        return _context;
    }
    public void setContext(Context context) {
        this._context = context;
    }

    public XmlManager getXmlManager() {
        if(_xmlManager == null){ _xmlManager = new XmlManager(); }
        return _xmlManager;
    }
    public void setXmlManager(XmlManager xmlManager) {
        this._xmlManager = xmlManager;
    }

    public List<Meal> getMeals() {
        if(_meals == null){ _meals = new ArrayList<Meal>(); }
        return _meals;
    }
    public void setMeals(List<Meal> meals) {
        this._meals = meals;
    }
}
