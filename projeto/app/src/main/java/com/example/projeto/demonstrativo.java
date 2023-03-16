package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class demonstrativo extends AppCompatActivity {
    TabLayout tabl;
    ViewPager2 pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demonstrativo);
        getSupportActionBar().hide(); // remove a barra no topo do app
        tabl = findViewById(R.id.tabl);
        pager = findViewById(R.id.pager);
        FragmentManager fm = getSupportFragmentManager();
        FragmentAtapter adaptadorDemonstrativo = new FragmentAtapter(fm, getLifecycle());
        pager.setAdapter(adaptadorDemonstrativo);
        tabl.setSelectedTabIndicatorColor(Color.parseColor("#faed3e"));
        tabl.setTabTextColors(Color.parseColor("#000000"), Color.parseColor("#FF0000"));
        tabl.addTab(tabl.newTab().setText("Médias")); //define quais sao os nomes que vao aparecer no layout do tab
        tabl.addTab(tabl.newTab().setText("Sugestoes"));
        tabl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabl.selectTab(tabl.getTabAt(position));
            }
        });
    }
}