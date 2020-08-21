package com.example.errorbox.hints;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.errorbox.R;

import android.app.Activity;
import android.widget.TextView;

public class HintAFragment {

    // activity var
    Context context;
    Activity activity;

    // views
    TextView tv_hint;
    Button button_close;

    public HintAFragment(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;

        if (dialog == null) {
            setUp();
        }
    }

    Dialog dialog;

    void setUp() {
        // initialising dialog
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.hint_a_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog
                .getWindow()
                .setLayout(
                        RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        tv_hint = dialog.findViewById(R.id.tv_hint_a);
        button_close  = dialog.findViewById(R.id.button_hint_a_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destroy();
            }
        });
    }

    public void init(String text) {
        tv_hint.setText(text);
        dialog.show();
    }

    void destroy() {
        dialog.dismiss();
    }
}