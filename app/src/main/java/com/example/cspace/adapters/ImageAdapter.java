package com.example.cspace.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.cspace.R;

public class ImageAdapter extends BaseAdapter {

    private Context context;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView==null) {
            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(350,350));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.drawable.hidden);
        } else {
            imageView = (ImageView) convertView;
            imageView.setImageResource(R.drawable.hidden);
        }
        return imageView;
    }
}
