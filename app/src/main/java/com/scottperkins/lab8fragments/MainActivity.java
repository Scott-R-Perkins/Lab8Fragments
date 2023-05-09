package com.scottperkins.lab8fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements RecipeListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Works but its better to just make a "values-large" folder and have a separate strings.xml with specific values for the folders qualifiers
        //there was a way (I think when creating the folders), to set what the qualifiers are for android to use that folder instead of using
        //the default folder. Might have been file specific, rather than folders.

        //FragmentContainerView detailFragment = findViewById(R.id.detail_fragment_container);
        //if (detailFragment != null) {
        //    this.setTitle("Tablet");
        //}
    }

    public void onShowRecipeClick(View view) {
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }

    @Override
    public void itemClicked(long id) {
        FragmentContainerView detailFragment = findViewById(R.id.detail_fragment_container);
        if (detailFragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            RecipeDetailFragment fragment = new RecipeDetailFragment();
            fragment.setRecipeId(id);
            transaction.replace(R.id.detail_fragment_container, fragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else{
            //Change strings.xml app name to "Lab8Fragments" might not need to change
            Intent intent = new Intent(this, RecipeActivity.class);
            intent.putExtra(RecipeActivity.EXTRA_RECIPE_ID, (int) id);
            startActivity(intent);
        }
    }
}