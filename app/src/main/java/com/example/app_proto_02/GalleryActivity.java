package com.example.app_proto_02;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    List<Cell> allFilesPaths;
    TextView galleryStatus;
    Button btnCapture;

    private static final int READ_PERMISSION_CODE = 1000;
    private static final int WRITE_CAPTURE_PERMISSION_CODE = 1001;
    private static final int IMAGE_CAPTURE_CODE = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        galleryStatus = findViewById(R.id.txtNoPics);
        btnCapture = findViewById(R.id.btnTakePhoto);

        // Storage Permissions
        String[] PERMISSIONS = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
        };

        if (!PermissionHelper.hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, READ_PERMISSION_CODE);
        } else {
            loadImages();
        }

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Camera Permissions
                String[] PERMISSIONS = {
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
                };

                if (!PermissionHelper.hasPermissions(getApplicationContext(), PERMISSIONS)) {
                    ActivityCompat.requestPermissions(GalleryActivity.this, PERMISSIONS, WRITE_CAPTURE_PERMISSION_CODE);
                } else {
                    openCamera();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case READ_PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Read external storage permission granted", Toast.LENGTH_SHORT).show();
                    loadImages();
                } else {
                    Toast.makeText(this, "Read external storage permission denied", Toast.LENGTH_SHORT).show();
                    BackToMain();
                }
            } break;

            case WRITE_CAPTURE_PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show();
                    openCamera();
                }
                else {
                    Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show();
                }
            } break;
        }
    }

    private void BackToMain() {
        // Go back to main menu. Edit after integration
         startActivity(new Intent(GalleryActivity.this, scroll_options.class));
    }

    public void onBackClick(View view) {
        BackToMain();
    }
    private ArrayList<Cell> prepareData() {
        ArrayList<Cell> allImages = new ArrayList<>();
        for (Cell c : allFilesPaths) {
            Cell cell = new Cell();
            cell.setTitle(c.getTitle());
            cell.setPath(c.getPath());
            allImages.add(cell);
        }

        return allImages;
    }

    private List<Cell> listAllFiles(String pathName) {
        List<Cell> allFiles = new ArrayList<>();
        File file = new File(pathName);
        File[] files = file.listFiles();


        if (files != null) {
            for (File f : files) {
                Cell cell = new Cell();
                cell.setTitle(f.getName());
                cell.setPath(f.getAbsolutePath());
                allFiles.add(cell);
            }
        }

        return allFiles;
    }

    private void loadImages(){
        String path = getExternalMediaDirs()[0].getAbsolutePath() + "/Demo/";
        allFilesPaths = new ArrayList<>();
        allFilesPaths = listAllFiles(path);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_gallery_images);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        // Optimize
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        ArrayList<Cell> cells = prepareData();
        MyAdapter adapter = new MyAdapter(GalleryActivity.this, cells);
        recyclerView.setAdapter(adapter);

        if (cells.isEmpty()) {
            galleryStatus.setVisibility(View.VISIBLE);
        } else {
            galleryStatus.setVisibility(View.INVISIBLE);
        }
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CAPTURE_CODE && resultCode == RESULT_OK) {
            Intent intent = new Intent(GalleryActivity.this, CameraActivity.class);
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            intent.putExtra("bitmap", bitmap);
            startActivity(intent);
        }
    }
}