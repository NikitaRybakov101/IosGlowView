package com.example.iosview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
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

        binding.iosInput.setGlowRed();
        binding.iosInput2.setGlowBlue();
        binding.iosInput3.setGlowBlue();
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
        binding.search2.setOnQueryTextFocusChangeListener((view,isFocus) -> {

            if (isFocus) {
                binding.iosInput2.animElevationUp();
            } else {
                binding.iosInput2.animElevationDown();
           //     binding.search2.onActionViewCollapsed();
            }
        });


        binding.search2.setOnClickListener(view -> {
            binding.search2.onActionViewExpanded();
        });
    }

    private void initSearchIosView3() {
        binding.search3.setOnQueryTextFocusChangeListener((view,isFocus) -> {

            if (isFocus) {
                binding.iosInput3.animElevationUp();
            } else {
                binding.iosInput3.animElevationDown();
           //     binding.search3.onActionViewCollapsed();
            }
        });


        binding.search3.setOnClickListener(view -> {
            binding.search3.onActionViewExpanded();
        });
    }
}