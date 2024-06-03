package com.pushwoosh.demoapp.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.pushwoosh.Pushwoosh;
import com.pushwoosh.demoapp.databinding.FragmentHomeBinding;
import com.pushwoosh.inapp.PushwooshInApp;
import com.pushwoosh.tags.TagsBundle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // SET TAGS
        TextInputEditText textInput1 = binding.textInput1;
        TextInputEditText textInput2 = binding.textInput2;
        Button setTags = binding.button;

        // REGISTER USER
        TextInputEditText registerUserTextField = binding.textInput3;
        Button registerUser = binding.button2;

        // POST EVENT
        TextInputEditText postEventTextField = binding.textInput4;
        Button postEvent = binding.button3;
        Switch attributes = binding.switch3;

        //

        setTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = Objects.requireNonNull(textInput1.getText()).toString();
                String value2 = Objects.requireNonNull(textInput2.getText()).toString();

            }
        });

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Objects.requireNonNull(registerUserTextField.getText()).toString();
                Pushwoosh.getInstance().setUserId(user);
            }
        });

        postEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName = Objects.requireNonNull(postEventTextField.getText()).toString();
                PushwooshInApp.getInstance().postEvent(eventName);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}