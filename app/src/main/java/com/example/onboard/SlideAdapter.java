package com.example.onboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context=context;

    }
    //arr
    public int[] slide_images={
            R.drawable.delivery,
            R.drawable.pay,
            R.drawable.member
    };
    public String[] slide_headings={
        "FUEL AT YOUR DOOR STEPS",
        "EASY AND SAFE PAYMENT",
        "WELCOME"
    };
    public String[] slide_desc={

            "Get fuel at your doorsteps ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, a. ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sua."
};


    @Override
    public int getCount() {

        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object o) {
        return view==( RelativeLayout) o;
    }

    @SuppressLint("ServiceCast")
    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.slide_layout, container , false);
        ImageView slideImageView= (ImageView) view.findViewById(R.id.imageView2);
        TextView slideHeading= (TextView) view.findViewById(R.id.heading);
        TextView slideDescription= (TextView) view.findViewById(R.id.information);

        slideImageView.setImageResource(slide_images [position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        container.removeView((RelativeLayout)object);
    }
}
