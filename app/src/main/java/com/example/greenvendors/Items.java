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
                   new Account()).commit();
       }

        // Create an ArrayList of Dessert objects
        final ArrayList<Dessert> desserts = new ArrayList<Dessert>();

        desserts.add(new Dessert("Donut"));
        desserts.add(new Dessert("Cookie"));
        desserts.add(new Dessert("Piece of cake"));
        desserts.add(new Dessert("Pastry"));
        desserts.add(new Dessert("Donut"));
        desserts.add(new Dessert("Cookie"));
        desserts.add(new Dessert("Piece of cake"));
        desserts.add(new Dessert("Pastry"));desserts.add(new Dessert("Donut"));
        desserts.add(new Dessert("Cookie"));
        desserts.add(new Dessert("Piece of cake"));
        desserts.add(new Dessert("Pastry"));desserts.add(new Dessert("Donut"));
        desserts.add(new Dessert("Cookie"));
        desserts.add(new Dessert("Piece of cake"));
        desserts.add(new Dessert("Pastry"));
        desserts.add(new Dessert("Donut"));
        desserts.add(new Dessert("Cookie"));
        desserts.add(new Dessert("Piece of cake"));
        desserts.add(new Dessert("Pastry"));





        // Create an {@link DessertAdapter}, whose data source is a list of
        // {@link Dessert}s. The adapter knows how to create list item views for each item
        // in the list.
        DesertAdapter flavorAdapter = new DesertAdapter(this, desserts);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_dessert);
        listView.setAdapter(flavorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Dessert dessert = desserts.get(i);
                switch(i) {
                    case 0:
                        Intent donut = new Intent(Items.this, Kunde.class);
                        startActivity(donut);
                        break;
                    case 1:
                        Intent cookie = new Intent(Items.this, Managu.class);
                        startActivity(cookie);
                        break;
                    case 2:
                        Intent pieceOfCake = new Intent(Items.this, Amaranthus.class);
                        startActivity(pieceOfCake);
                        break;
                    case 3:
                        Intent pastry = new Intent(Items.this, Bananas.class);
                        startActivity(pastry);
                        break;
                }
            }
        });
    }
    public void Decrement(View view) {

        LinearLayout parentRow = (LinearLayout) view.getParent();

        TextView quantityView = (TextView) parentRow.findViewById(R.id.dessert_number);
        String quantityString = quantityView.getText().toString();
        desertNumber = Integer.parseInt(quantityString);
        desertNumber -= 1;

        if (desertNumber < 0) {
            desertNumber = 0;
            Toast.makeText(Items.this, "Can not be less than 0",
                    Toast.LENGTH_SHORT).show();}
        quantityView.setText(String.valueOf(desertNumber));
    }
    public void Increment(View view) {

        LinearLayout parentRow = (LinearLayout) view.getParent();

        TextView quantityView = (TextView) parentRow.findViewById(R.id.dessert_number);
        String quantityString = quantityView.getText().toString();
        desertNumber = Integer.parseInt(quantityString);
        desertNumber += 1;
        quantityView.setText(String.valueOf(desertNumber));
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener(){
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
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };

}