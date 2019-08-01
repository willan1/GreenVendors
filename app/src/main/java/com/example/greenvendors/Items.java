package com.example.greenvendors;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Items extends AppCompatActivity {

    int desertNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);




        // added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                   new Products()).commit();
       }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.
            OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment= null;

            switch (menuItem.getItemId()) {
                case R.id.menu_item1:
                    selectedFragment = new Account();
                    break;
                case R.id.menu_item2:
                    selectedFragment = new Cart();
                    break;
                case R.id.menu_item3:
                    selectedFragment = new Search();
                    break;
                case R.id.menu_item4:
                    selectedFragment = new Products();
                    break;


            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };


}