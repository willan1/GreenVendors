package com.example.greenvendors;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Products extends Fragment {

    public Products(){

    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.products, container, false);

        final ArrayList<String> desserts = new ArrayList<>();

        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");
        desserts.add("Donut");

        // Create an {@link DessertAdapter}, whose data source is a list of
        // {@link Dessert}s. The adapter knows how to create list item views for each item
        // in the list.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.<Context>requireNonNull(getContext()),
                android.R.layout.simple_list_item_1, desserts);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView =view.findViewById(R.id.listview_dessert);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Dessert dessert = desserts.get(i);
                switch(i) {
                    case 0:
                        Intent donut = new Intent(getActivity(), Kunde.class);
                        startActivity(donut);
                        break;
                    case 1:
                        Intent cookie = new Intent(getActivity(), Managu.class);
                        startActivity(cookie);
                        break;

                }
            }
        });





        return view;
    }
}
