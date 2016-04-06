package com.fatfat.hw1_1;

import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int[] images = new int[]{R.drawable.dino, R.drawable.pig, R.drawable.pink, R.drawable.punk, R.drawable.witch};
    private ViewPagerAdapter vpa;
    private ArrayList<View> views;
    private ViewPager viewPager;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(1 + "/" + images.length);
        views = new ArrayList<>(images.length);
        for(int i=0;i<images.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setAdjustViewBounds(true);
            views.add(imageView);
        }

        viewPager = (ViewPager)findViewById(R.id.view);
        vpa = new ViewPagerAdapter(views);
        viewPager.setAdapter(vpa);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                textView.setText((position + 1) + "/" + images.length);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Button backBtn = (Button) findViewById(R.id.backBtn);
        Button goBtn = (Button) findViewById(R.id.goBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.arrowScroll(View.FOCUS_LEFT);
            }
        });
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.arrowScroll(View.FOCUS_RIGHT);
            }
        });
    }
}
