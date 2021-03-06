package com.example.app_proto_02;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Cell> galleryList;
    private Context context;

    public MyAdapter(Context context, ArrayList<Cell> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell, viewGroup, false);

        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setImageFromPath(galleryList.get(i).getPath(), viewHolder.image);
        String caption = galleryList.get(i).getTitle();
        caption = caption.substring(0, caption.length()-4);
        viewHolder.caption.setText(caption);

        final String finalCaption = caption;
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SingleImageViewActivity.class);
                intent.putExtra("ImagePath", galleryList.get(i).getPath());
                intent.putExtra("ImageCaption", finalCaption);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView caption;

        public ViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.img);
            caption = (TextView) view.findViewById(R.id.caption);
        }
    }

    private void setImageFromPath(String path, ImageView img) {
        File imgFile = new File(path);
        if (imgFile.exists()) {
            Bitmap myBitmap = ImageHelper.decodeSampledBitmapFromPath(imgFile.getAbsolutePath(), 200, 200);
            img.setImageBitmap(myBitmap);
        }
    }
}
