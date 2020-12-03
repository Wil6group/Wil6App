package com.example.app_proto_02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class SingleImageViewActivity extends AppCompatActivity {

    Button backButton;
    Button deleteButton;
    TextView caption;
    ImageView singleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_image_view);

        backButton = findViewById(R.id.btnSingleBack);
        deleteButton = findViewById(R.id.btnPictureDelete);
        caption = findViewById(R.id.single_caption);
        singleImage = findViewById(R.id.imgSingle);

        final Intent intent = getIntent();
        String imageCaption = intent.getExtras().get("ImageCaption").toString();
        caption.setText(imageCaption);

        final String path = intent.getExtras().get("ImagePath").toString();

        final File imgFile = new  File(path);

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            singleImage.setImageBitmap(myBitmap);

        } else {
            Back();
            Toast.makeText(SingleImageViewActivity.this, "The image does not exist", Toast.LENGTH_SHORT).show();
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFile.delete();
                Back();
                Toast.makeText(SingleImageViewActivity.this, "Image Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Back() {
        Intent intent1 = new Intent(SingleImageViewActivity.this, GalleryActivity.class);
        startActivity(intent1);
        finish();
    }
}