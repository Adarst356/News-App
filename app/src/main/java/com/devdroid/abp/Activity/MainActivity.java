package com.devdroid.abp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.devdroid.abp.Fragment.PagerAdapter;
import com.devdroid.abp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem home,science,health,sports,entertainment,technology;

    ViewPager2 viewPager;
    Toolbar toolbar;


    String api= "664f865f3edb416595ac532537738155";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        home=findViewById(R.id.Home);
        science=findViewById(R.id.Science);
        health=findViewById(R.id.Health);
        sports=findViewById(R.id.sport);
        entertainment=findViewById(R.id.entertainment);
        technology=findViewById(R.id.technology);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);

        // Link tab selection to page changes
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (tabLayout.getSelectedTabPosition() != position) {
                    tabLayout.selectTab(tabLayout.getTabAt(position));
                }
            }
        });
    }
}
