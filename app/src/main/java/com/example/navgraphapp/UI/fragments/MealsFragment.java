package com.example.navgraphapp.UI.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.navgraphapp.R;
import com.example.navgraphapp.UI.adapters.MealsAdapter;
import com.example.navgraphapp.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealsFragment extends Fragment implements MealsAdapter.OnMealClickListener {

    private RecyclerView recyclerView;
    private MealsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_food_items);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        List<Meal> dummyData = new ArrayList<>();
        dummyData.add(new Meal("Beef Burger", "₦ 3500.00", "Crunchy beef burger with onion", "25 mins", R.drawable.img_burger_large));
        dummyData.add(new Meal("Cheese Pizza", "₦ 5000.00", "Cheesy goodness with extra toppings", "40 mins", R.drawable.food1));

        adapter = new MealsAdapter(dummyData, this);
        recyclerView.setAdapter(adapter);

        DrawerLayout drawerLayout = requireActivity().findViewById(R.id.drawer_layout);

        ImageView btnMenu = view.findViewById(R.id.btn_menu);

        btnMenu.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });
    }

    @Override
    public void onMealClick(Meal meal, View view) {
        MealsFragmentDirections.ActionMealsFragmentToMealDetailsFragment action =
                MealsFragmentDirections.actionMealsFragmentToMealDetailsFragment(meal);

        Navigation.findNavController(view).navigate(action);
    }
}