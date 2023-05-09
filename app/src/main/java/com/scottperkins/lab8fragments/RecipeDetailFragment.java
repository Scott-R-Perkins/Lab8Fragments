package com.scottperkins.lab8fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecipeDetailFragment extends Fragment {

    private long recipeId;
    public void setRecipeId(long id){
        this.recipeId = id;
    }

    public RecipeDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if(view != null){
            Recipe recipe = Recipe.recipes[(int)recipeId];
            TextView name = view.findViewById(R.id.textViewRecipeNameID);
            name.setText(recipe.getName());
            TextView description = view.findViewById(R.id.textViewRecipeDescriptionID);
            description.setText(recipe.getDescription());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInsatnceState){
        super.onCreate(savedInsatnceState);
        if (savedInsatnceState != null) {
            recipeId = savedInsatnceState.getLong("recipeId");
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        outState.putLong("recipeId", recipeId);
    }
}