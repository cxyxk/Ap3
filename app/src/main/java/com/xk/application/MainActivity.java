package com.xk.application;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnClickListener {


    public static MainActivity mainActivity;

    private List<Fragment> fragmentList;
    private ViewPager viewpager;
    private TextView tvYC, tvLLQ, tvGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViewPager();


    }


    private void initViewPager() {
        viewpager = findViewById(R.id.view_pager);

        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(3);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int p1, float p2, int p3) {
            }

            @Override
            public void onPageSelected(int p1) {
                switch (p1) {
                    case 0:

                        tvYC.setBackgroundColor(Color.RED);
                        tvLLQ.setBackgroundColor(Color.WHITE);
                        tvGuest.setBackgroundColor(Color.WHITE);

                        break;
                    case 1:

                        tvYC.setBackgroundColor(Color.WHITE);
                        tvLLQ.setBackgroundColor(Color.RED);
                        tvGuest.setBackgroundColor(Color.WHITE);
                        break;
                    case 2:
                        tvYC.setBackgroundColor(Color.WHITE);
                        tvLLQ.setBackgroundColor(Color.WHITE);
                        tvGuest.setBackgroundColor(Color.RED);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int p1) {
            }
        });
    }


    private void initData() {
        tvYC = findViewById(R.id.tvYC);
        tvYC.setText(R.string.nav_yc);
        tvLLQ = findViewById(R.id.tvLLQ);
        tvLLQ.setText(R.string.nav_web);
        tvGuest = findViewById(R.id.tvGuest);
        tvGuest.setText(R.string.nav_guest);
        tvYC.setOnClickListener(this);
        tvLLQ.setOnClickListener(this);
        tvGuest.setOnClickListener(this);
        fragmentList = new ArrayList<>();
        fragmentList.add(new YuCeFragment());
        fragmentList.add(new WebFragment());
        fragmentList.add(new GuestFragment());
        fragmentList.add(new RandomFragment());
    }

    @Override
    public void onClick(View p1) {
        switch (p1.getId()) {
            case R.id.tvYC:
                viewpager.setCurrentItem(0);
                break;
            case R.id.tvLLQ:
                viewpager.setCurrentItem(1);
                break;
            case R.id.tvGuest:
                viewpager.setCurrentItem(2);
                break;
        }
    }

}
