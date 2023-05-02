package com.scottperkins.lab8fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RecipeActivity extends AppCompatActivity {
    public static final String EXTRA_RECIPE_ID = "RecipeID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        RecipeDetailFragment fragment = (RecipeDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        int recipeId = getIntent().getIntExtra(EXTRA_RECIPE_ID, 0);
        fragment.setRecipeId(recipeId);
    }
}