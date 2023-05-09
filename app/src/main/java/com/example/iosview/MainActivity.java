package com.example.iosview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.SearchableInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


import com.example.iosview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initSearchIosView();
        initSearchIosView2();
        initSearchIosView3();

        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:

                binding.iosInput.setLightTheme();
                binding.iosInput2.setLightTheme();
                binding.iosInput3.setLightTheme();

                break;
            case Configuration.UI_MODE_NIGHT_YES:

                binding.iosInput.setNightTheme();
                binding.iosInput2.setNightTheme();
                binding.iosInput3.setNightTheme();
                break;
        }
    }

    private void initSearchIosView() {
        binding.search.setOnQueryTextFocusChangeListener((view,isFocus) -> {

            if (isFocus) {
                binding.iosInput.animElevationUp();
            } else {
                binding.iosInput.animElevationDown();
                binding.search.onActionViewCollapsed();
            }
        });


        binding.search.setOnClickListener(view -> {
              binding.search.onActionViewExpanded();
        });
    }

    private void initSearchIosView2() {
        binding.search2.setOnFocusChangeListener((view,isFocus) -> {

            if (isFocus) {
                binding.iosInput2.animElevationUp();
            } else {
                binding.iosInput2.animElevationDown();
            }
        });
    }

    private void initSearchIosView3() {
        binding.search3.setOnFocusChangeListener((view,isFocus) -> {

            if (isFocus) {
                binding.iosInput3.animElevationUp();
            } else {
                binding.iosInput3.animElevationDown();
            }
        });
    }
}