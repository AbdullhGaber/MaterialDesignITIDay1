package com.example.navgraphapp.UI.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.navgraphapp.R;
import com.example.navgraphapp.model.Meal;

public class MealDetailsFragment extends Fragment {
    private TextView tvTitle, tvPrice, tvDesc, tvDelivery;
    private ImageView ivImage, btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meal_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTitle = view.findViewById(R.id.tv_product_title);
        tvPrice = view.findViewById(R.id.tv_price_tag);
        tvDesc = view.findViewById(R.id.tv_desc_body);
        tvDelivery = view.findViewById(R.id.tv_delivery_value);
        ivImage = view.findViewById(R.id.iv_main_product);
        btnBack = view.findViewById(R.id.btn_back);

        if (getArguments() != null) {
            MealDetailsFragmentArgs args = MealDetailsFragmentArgs.fromBundle(getArguments());
            Meal receivedMeal = args.getMeal();

            if (receivedMeal != null) {
                tvTitle.setText(receivedMeal.getTitle());
                tvPrice.setText(receivedMeal.getPrice());
                tvDesc.setText(receivedMeal.getDescription());
                tvDelivery.setText(receivedMeal.getDeliveryTime());
                ivImage.setImageResource(receivedMeal.getImageResId());
            }
        }

        btnBack.setOnClickListener(v -> Navigation.findNavController(view).navigateUp());
    }
}