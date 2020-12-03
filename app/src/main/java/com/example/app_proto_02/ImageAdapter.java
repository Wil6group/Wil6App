package com.example.app_proto_02;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context context;

    public ImageAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 16;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            wm.getDefaultDisplay().getMetrics((displaymetrics));
            int screenWidth = displaymetrics.widthPixels;
            int colDim = screenWidth / 4;

            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new GridView.LayoutParams(colDim,colDim));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }else imageView = (ImageView)convertView;

        imageView.setImageResource(R.drawable.questionmark);

        return imageView;
    }
}
