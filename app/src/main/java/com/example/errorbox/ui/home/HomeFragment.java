package com.example.errorbox.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.errorbox.R;
import com.example.errorbox.hints.HintAFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    TextView tv_hint;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        tv_hint = root.findViewById(R.id.tv_hint);
        SpannableString str = new SpannableString("Click here for Hint");
        str.setSpan(new ForegroundColorSpan(Color.RED), 6, 10, 0);
        tv_hint.setText(str);
        tv_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHint();
            }
        });
        return root;
    }

    public void getHint() {
        HintAFragment hintAFragment = new HintAFragment(getContext(), getActivity());
        hintAFragment.init("If in life you are not getting any way just " +
                "make the invisible things visible and then you know where to go");
    }
}