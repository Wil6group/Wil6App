package com.example.app_proto_02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class scroll_options extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_options);

        navView();
    }

    //---Scroll options to open sections---Shaun
    public void Camera(View view)
    {
        startActivity(new Intent(scroll_options.this, GalleryActivity.class));
    }
    public void Colours(View view)
    {
        startActivity(new Intent(scroll_options.this, colours.class));
    }
    public void Numbers(View view)
    {
        startActivity(new Intent(scroll_options.this, numbers.class));
    }
    public void Animals(View view)
    {
        startActivity(new Intent(scroll_options.this, animals.class));
    }

    public void Shapes(View view)
    {
        startActivity(new Intent(scroll_options.this,shapes.class));
    }
    public void Body(View view)
    {
        startActivity(new Intent(scroll_options.this,body.class));
    }
    //---Scroll options end

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //Nav menu done by Shivaar

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.side_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Nav Menu on top right (Not needed now)
        int id = item.getItemId();

        if (id == R.id.menu_about)
        {

        }

        if (mToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) //Nav Drawer navigation to other activities. Connected to nav_menu.xml in res -> menu
    {
        int id = menuItem.getItemId();

        if (id == R.id.nav_home)
        {
            startActivity(new Intent(scroll_options.this, scroll_options.class));
        }
        if (id == R.id.nav_animal)
        {
            startActivity(new Intent(scroll_options.this, animals.class));
        }
        if (id == R.id.nav_Body)
        {
            startActivity(new Intent(scroll_options.this, body.class));
        }
        if (id == R.id.nav_colour)
        {
            startActivity(new Intent(scroll_options.this, colours.class));
        }
        if (id == R.id.nav_number)
        {
            startActivity(new Intent(scroll_options.this, numbers.class));
        }
        if (id == R.id.nav_shapes)
        {
            startActivity(new Intent(scroll_options.this, shapes.class));
        }
        if (id == R.id.nav_picMatch)
        {
            startActivity(new Intent(scroll_options.this, PicMatchingMenu.class));
        }
        if (id == R.id.nav_anagram)
        {
            startActivity(new Intent(scroll_options.this, TestAnagram.class));
        }
        if (id == R.id.nav_portal)
        {
        }
        return false;
    }

    private void navView() //No need to alter
    {
        mDrawerLayout = findViewById(R.id.ScrollDrawer);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
