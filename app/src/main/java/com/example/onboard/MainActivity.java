package com.example.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SlideAdapter sliderAdapter;
    private TextView[] mDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewpager);
        mDotLayout= (LinearLayout) findViewById(R.id.dotLayout);
        sliderAdapter= new SlideAdapter(this);
        mSlideViewPager.setAdapter((sliderAdapter));

        mSlideViewPager.addOnPageChangeListener(viewListener);
    }
    public void addDots(int position){
        mDots= new TextView[3];
        mDotLayout.removeAllViews();
        for (int i=0; i<mDots.length;i++){

            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimary));
            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));


        }
    }
    ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {

            addDots(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}