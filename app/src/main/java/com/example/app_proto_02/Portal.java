package com.example.app_proto_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Portal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);

    }
    public void onFaceBookClick(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.Google.com"));
        startActivity(intent);
    }
    public void onInstructionalFactsClick(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://gigisplayhouse.org/quadcities/uncategorized/five-instructional-strategies-for-children-with-down-syndrome"));
        startActivity(intent);
    }
    public void onParentingClick(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.webmd.com/children/parenting-child-downs-syndrome"));
        startActivity(intent);
    }
    public void onLessonsClick(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.parents.com/health/down-syndrome/raising-a-child-with-down-syndrome/"));
        startActivity(intent);
    }
    public void onBackClick(View view)
    {
        startActivity(new Intent(Portal.this, scroll_options.class));
    }
}