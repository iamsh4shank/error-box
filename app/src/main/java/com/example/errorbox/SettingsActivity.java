package com.example.errorbox;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import com.example.errorbox.hints.HintAFragment;
import com.example.errorbox.utils.Constants;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            Preference myPref = (Preference) findPreference("cred");
            SwitchPreference switch1 = findPreference("sync");
            SwitchPreference switch2 = findPreference("attachment");
            SwitchPreference switch3 = findPreference("depends");

            //switch working
            if (switch1.isChecked() && switch2.isChecked()) {
                if (!switch3.isChecked()) {
                    myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                        public boolean onPreferenceClick(Preference preference) {
                            HintAFragment hintAFragment = new HintAFragment(getContext(), getActivity());
                            hintAFragment.init("Username - " + Constants.username + "\nPassword - " + Constants.password);
                            return true;
                        }
                    });
                }
            }

            else {
                myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    public boolean onPreferenceClick(Preference preference) {
                        HintAFragment hintAFragment = new HintAFragment(getContext(), getActivity());
                        hintAFragment.init("Make a correct combination of switches to unlock this. Look SettingsActivity to understand how mechanism works.");
                        return true;
                    }
                });
            }
        }
    }
}