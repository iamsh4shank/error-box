package com.example.errorbox.ui.extended;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.errorbox.R;
import com.example.errorbox.ui.GameFragment;

public class ExtendedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_extended);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Button buttonQuiz = findViewById(R.id.button_quiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonQuiz.setVisibility(View.INVISIBLE);
            }
        });
    }
    //remove comment and add FragmentTransaction
    public void openGame() {
        //write function to open game
    }
}

