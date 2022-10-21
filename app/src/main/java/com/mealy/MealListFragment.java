package com.mealy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.mealy.data.Meal;
import com.mealy.databinding.FragmentMealListBinding;
import com.mealy.utils.Manager;

public class MealListFragment extends Fragment {
    //View elements
    ListView _mealListView;
    //Variables
    private FragmentMealListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        binding = FragmentMealListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewElements(view);

        binding.addMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MealListFragment.this).navigate(R.id.action_meal_list_to_meal_editor);

                for(Meal meal: Manager.getInstance().getMeals()){
                    System.out.println(meal.getTitle());
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void findViewElements(View view){
        _mealListView = (ListView) view.findViewById(R.id.meal_list_listview);
    }

}