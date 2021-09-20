package com.example.phoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.phoneapp.adapter.ViewPagerAdapter;
import com.example.phoneapp.fragments.FragmentCalls;
import com.example.phoneapp.fragments.FragmentContacts;
import com.example.phoneapp.fragments.FragmentFav;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
       private TabLayout tabLayout;
       private ViewPager viewPager;

       private final int[] ICONS ={R.drawable.ic_baseline_call_24,R.drawable.ic_baseline,R.drawable.ic_baseline_star_rate_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentCalls(),"Calls");
        adapter.addFragment(new FragmentContacts(),"Contacts");
        adapter.addFragment(new FragmentFav(),"Fav");

        viewPager.setAdapter(adapter);

         tabLayout.setupWithViewPager(viewPager);
         for (int i=0;i<tabLayout.getTabCount();i++){
             TabLayout.Tab tab =tabLayout.getTabAt(i);
             tab.setIcon(ICONS[i]);
         }

    }
    private void askPermission(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CALL_LOG},1);

        }
    }
}