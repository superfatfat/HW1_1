package com.fatfat.hw1_1;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by cuser on 2016/4/6.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private ArrayList<View> views;

    public ViewPagerAdapter(ArrayList<View> views){
        this.views = views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(views.get(position), 0);
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(views.get(position));
    }

    @Override
    public int getCount() {
        if(views != null){
            return views.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
