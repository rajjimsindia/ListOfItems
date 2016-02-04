package com.demo.raj.listofitems.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.raj.listofitems.R;
import com.demo.raj.listofitems.fragments.ItemsFragment;

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
