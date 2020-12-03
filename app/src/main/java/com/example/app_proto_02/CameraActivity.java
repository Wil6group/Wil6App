package com.example.app_proto_02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CameraActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnSave;
    Button btnBack;
    EditText edtName;

    String imageName;

    OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageView = findViewById(R.id.imgView);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack);
        edtName = findViewById(R.id.editPhotoDetails);

        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getExtras().get("bitmap");
        imageView.setImageBitmap(bitmap);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageName = edtName.getText().toString().trim();

                if (imageName.isEmpty()) {
                    Toast.makeText(CameraActivity.this, "Please name your family member", Toast.LENGTH_SHORT).show();
                    edtName.requestFocus();
                    return;
                }

                SavePicture();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToGalleryActivity();
            }
        });
    }

    public void SavePicture() {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        imageName = imageName.substring(0, 1).toUpperCase() + imageName.substring(1).toLowerCase();

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();

        File filepath = getExternalMediaDirs()[0];
        String path = filepath.getAbsolutePath()  + "/Demo/" + uid + "/";
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdirs();
        }
        //dir.mkdir();

        try {
            File file = new File(dir, imageName + ".jpg");

            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
            outputStream = new FileOutputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        Toast.makeText(getApplicationContext(), "Image Saved", Toast.LENGTH_SHORT).show();


        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ToGalleryActivity();
    }

    public void ToGalleryActivity(){
        Intent intent = new Intent(CameraActivity.this, GalleryActivity.class);
        startActivity(intent);
    }
}