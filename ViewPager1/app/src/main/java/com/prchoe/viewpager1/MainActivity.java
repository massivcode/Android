package com.prchoe.viewpager1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class MainActivity extends Activity {

    CustomPagerAdapter customPagerAdapter;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager)findViewById(R.id.pager);
        customPagerAdapter = new CustomPagerAdapter(getApplicationContext());
        pager.setAdapter(customPagerAdapter);
    }


}
