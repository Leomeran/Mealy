package com.mealy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.mealy.data.Meal;
import com.mealy.databinding.FragmentMealEditorBinding;
import com.mealy.utils.Manager;

public class MealEditorFragment extends Fragment {

    private FragmentMealEditorBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMealEditorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MealEditorFragment.this).navigate(R.id.action_meal_editor_to_meal_list);

                Meal meal = new Meal();
                meal.setTitle("Meal n°" + Manager.getInstance().getMeals().size());
                Manager.getInstance().getMeals().add(meal);
                Manager.getInstance().getXmlManager().saveMeals();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}