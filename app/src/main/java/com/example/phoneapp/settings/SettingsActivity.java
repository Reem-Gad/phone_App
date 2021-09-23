package com.example.phoneapp.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.phoneapp.R;
import com.example.phoneapp.UserSettings;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingsActivity extends AppCompatActivity {
    private View parentView;
    private SwitchMaterial themeSwitch;
    private TextView tv_theme, tv_title;
    public UserSettings settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings = (UserSettings) getApplication();

        initWidgets();
        loadSharedPreferences();
        initSwitchListener();
    }


    private void initWidgets() {
        tv_theme = findViewById(R.id.tv_theme);
        tv_title = findViewById(R.id.tv_title);
        themeSwitch = findViewById(R.id.theme_switch);
        parentView = findViewById(R.id.parentView);
    }

    private void loadSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE);
        String theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME);
        settings.setCustomTheme(theme);
    }

    private void initSwitchListener() {
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {

                if(checked)
                    settings.setCustomTheme(UserSettings.DARK_THEME);
                else
                    settings.setCustomTheme(UserSettings.LIGHT_THEME);

                SharedPreferences.Editor editor=getSharedPreferences(UserSettings.PREFERENCES,MODE_PRIVATE).edit();
                editor.putString(UserSettings.CUSTOM_THEME,settings.getCustomTheme());
                editor.apply();
                updateView();

            }
        });


    }


    private void updateView () {
        final int black = ContextCompat.getColor(this, R.color.black);
        final int white = ContextCompat.getColor(this, R.color.white);
        if (settings.getCustomTheme().equals(UserSettings.DARK_THEME)) {
            tv_title.setTextColor(white);
            tv_theme.setTextColor(white);
            tv_theme.setText("Dark");
            parentView.setBackgroundColor(black);
            themeSwitch.setChecked(true);
        } else {
            tv_title.setTextColor(black);
            tv_theme.setTextColor(black);
            tv_theme.setText("Light");
            parentView.setBackgroundColor(white);
            themeSwitch.setChecked(false);
        }

    }


}
