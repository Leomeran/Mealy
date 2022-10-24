package com.mealy.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mealy.R;
import com.mealy.data.Meal;

import java.util.ArrayList;

public class MealListAdapter extends ArrayAdapter<Meal> {

    public MealListAdapter(Context context, ArrayList<Meal> mealList){
        super(context, R.layout.item_meal, mealList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Objects
        Meal meal = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_meal, parent, false);
        }

        //UI elements
        TextView mealTitleTewtView = convertView.findViewById(R.id.meal_title_textview);

        //Initialization
        mealTitleTewtView.setText(meal.getTitle());

        return convertView;
    }
}
