package com.mealy.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;

import com.mealy.MainActivity;
import com.mealy.R;
import com.mealy.data.Meal;

import java.util.ArrayList;

public class MealListAdapter extends ArrayAdapter<Meal> {
    private MotionLayout.TransitionListener transitionListener;

    public MealListAdapter(Context context, ArrayList<Meal> mealList){
        super(context, R.layout.item_meal, mealList);

        transitionListener = new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                Manager.getInstance().setListScrollable(false);
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {
                //System.out.println("\nCHANGE");
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                Manager.getInstance().setListScrollable(true);
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {
                //System.out.println("\nTRIGGER");
            }
        };
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
        TextView mealTitleTextView = convertView.findViewById(R.id.meal_title_textview);

        MotionLayout motionLayout = convertView.findViewById(R.id.constraintLayout);
        motionLayout.setTransitionListener(transitionListener);
        System.out.println("\nset listener");

        ImageButton editImageButton = convertView.findViewById(R.id.editImageButton);
        ImageButton deleteImageButton = convertView.findViewById(R.id.deleteImageButton);
        editImageButton.setOnClickListener(view -> {
            Manager.getInstance().setMealIndex(position);
            Manager.getInstance().setIsEditing(true);
            Manager.getInstance().getMealListFragment().updateMainActivityTitle();
            Manager.getInstance().getMealListFragment().goToMealEditor();
        });
        deleteImageButton.setOnClickListener(view -> {
            Manager.getInstance().setMealIndex(position);
            Manager.getInstance().setIsEditing(true);
            Manager.getInstance().getMeals().remove(position);
            Manager.getInstance().getMealListAdapter().notifyDataSetChanged();
            Manager.getInstance().getXmlManager().saveMeals();
            motionLayout.transitionToEnd();
        });

        //Initialization
        mealTitleTextView.setText(meal.getTitle());

        return convertView;
    }
}
