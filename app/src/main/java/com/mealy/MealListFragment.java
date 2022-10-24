package com.mealy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.mealy.data.Meal;
import com.mealy.databinding.FragmentMealListBinding;
import com.mealy.utils.Manager;
import com.mealy.utils.MealListAdapter;

public class MealListFragment extends Fragment {
    //Objects
    private FragmentMealListBinding _binding;
    //View elements
    ListView _mealListView;
    MealListAdapter _mealListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        _binding = FragmentMealListBinding.inflate(inflater, container, false);
        return _binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewElements(view);

        _mealListAdapter = new MealListAdapter(getContext(), Manager.getInstance().getMeals());
        _binding.mealListListview.setAdapter(_mealListAdapter);

        _binding.mealListListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                goToMealEditor();
            }
        });

        _binding.addMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMealEditor();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _binding = null;
    }

    //FUNCTIONS
    public void findViewElements(View view){
        _mealListView = (ListView) view.findViewById(R.id.meal_list_listview);
    }

    public void goToMealEditor(){
        NavHostFragment.findNavController(MealListFragment.this).navigate(R.id.action_meal_list_to_meal_editor);
    }

}