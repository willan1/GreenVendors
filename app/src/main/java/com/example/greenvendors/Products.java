package com.example.greenvendors;

import android.annotation.TargetApi;
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

import java.util.ArrayList;
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




        desserts.add("Managu");
        desserts.add("Terere");
        desserts.add("Murenda");
        desserts.add("Miroo/Mitoo");
        desserts.add("Sagaa/Saget");
        desserts.add("Kunde");
        desserts.add("Minji/Green Beans");
        desserts.add("Green Bananas");
        desserts.add("Nduma");
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
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()),
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
                        Intent managu = new Intent(getActivity(), Managu.class);
                        startActivity(managu);
                        break;
//                    case 1:
//                        Intent terere = new Intent(getActivity(), Terere.class);
//                        startActivity(terere);
//                        break;
//                    case 2:
//                        Intent murenda = new Intent(getActivity(), Murenda.class);
//                        startActivity(murenda);
//                        break;
                    case 3:
                        Intent kunde = new Intent(getActivity(), Kunde.class);
                        startActivity(kunde);
                        break;
//                    case 4:
//                        Intent minji = new Intent(getActivity(), Minji.class);
//                        startActivity(minji);
//                        break;
//                    case 5:
//                        Intent nduma = new Intent(getActivity(), Nduma.class);
//                        startActivity(nduma);
//                        break;
//                    case 6:
//                        Intent sagaa = new Intent(getActivity(), Sagaa.class);
//                        startActivity(sagaa);
//                        break;
//                    case 7:
//                        Intent miroo = new Intent(getActivity(), Miroo.class);
//                        startActivity(miroo);
//                        break;

                }
            }
        });
        return view;
    }
}
