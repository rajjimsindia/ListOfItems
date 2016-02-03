package com.demo.raj.listofitems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        // Add ItemsFragment to the ItemsActivity
        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new ItemsFragment())
                    .commit();
        }
    }
}
