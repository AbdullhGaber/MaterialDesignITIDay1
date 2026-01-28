package com.example.navgraphapp.UI.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navgraphapp.R;
import com.example.navgraphapp.model.Meal;

import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealViewHolder> {

    private List<Meal> mealList;
    private OnMealClickListener listener;

    public interface OnMealClickListener {
        void onMealClick(Meal meal, View view);
    }

    public MealsAdapter(List<Meal> mealList, OnMealClickListener listener) {
        this.mealList = mealList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = mealList.get(position);
        holder.bind(meal, listener);
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvPrice;
        ImageView ivFood;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPrice = itemView.findViewById(R.id.tv_price);
            ivFood = itemView.findViewById(R.id.iv_food);
        }

        public void bind(final Meal meal, final OnMealClickListener listener) {
            tvTitle.setText(meal.getTitle());
            tvPrice.setText(meal.getPrice());
            ivFood.setImageResource(meal.getImageResId());
            itemView.setOnClickListener(v -> listener.onMealClick(meal,v));
        }
    }
}