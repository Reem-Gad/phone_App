package com.example.phoneapp.launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.phoneapp.MainActivity;
import com.example.phoneapp.R;
import com.example.phoneapp.internal_storage;
import com.example.phoneapp.settings.SettingsActivity;

public class LauncherActivity extends AppCompatActivity {
    Button btn_setting,btn_call,btn_store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        btn_setting=findViewById(R.id.setting);
        btn_call=findViewById(R.id.call);
        btn_store=findViewById(R.id.store_btn);

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent=new Intent(LauncherActivity.this, SettingsActivity.class);
                startActivity(MyIntent);
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LauncherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentStorage=new Intent(LauncherActivity.this, internal_storage.class);
                startActivity(intentStorage);
            }
        });


    }
}