package com.example.errorbox.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.errorbox.R;
import com.example.errorbox.ui.extended.ExtendedActivity;
import com.example.errorbox.utils.Constants;
import com.google.android.material.textfield.TextInputEditText;

public class QuizFragment extends Fragment {

    private QuizViewModel quizViewModel;

    TextInputEditText username;
    TextInputEditText pwd;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        quizViewModel =
                ViewModelProviders.of(this).get(QuizViewModel.class);
        root = inflater.inflate(R.layout.fragment_quiz, container, false);
        username = root.findViewById(R.id.et_username);
        pwd = root.findViewById(R.id.et_password);
        final Button login = root.findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(username, pwd);

            }
        });
        return root;
    }

    public void login(TextInputEditText uname, TextInputEditText pwd) {

        //TODO

        if (uname.getText().toString() == (Constants.username) && pwd.getText().toString().equals(Constants.password)) {
            openFragment();
        } else {
            Toast.makeText(getActivity(), "Wrong Credentials! Try Again", Toast.LENGTH_SHORT).show();
        }
    }

    public void openFragment() {
        Intent intent = new Intent(getActivity(), ExtendedActivity.class);
        startActivity(intent);
    }
}