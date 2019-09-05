package com.example.greenvendors;

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

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Objects;

public class Account extends Fragment {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable
                                         Bundle savedInstanceState) {
        View accountadapter = inflater.inflate(R.layout.account, container, false);

        final ArrayList<String> accountitems = new ArrayList<>();

        accountitems.add("Log Out");
        accountitems.add("DFDF");
        accountitems.add("HG");
        accountitems.add("NGNGN");
        accountitems.add("GHGNGNG");
        accountitems.add("Donut");
        accountitems.add("Donut");
        accountitems.add("Donut");
        accountitems.add("Donut");
        accountitems.add("Donut");
        accountitems.add("Donut");
        accountitems.add("Donut");
        accountitems.add("Log Out");


        // Create an {@link DessertAdapter}, whose data source is a list of
        // {@link Dessert}s. The adapter knows how to create list item views for each item
        // in the list.
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(Objects.requireNonNull(getContext()),
                android.R.layout.simple_list_item_1, accountitems);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = accountadapter.findViewById(R.id.listview_dessert);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case 0:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent= new Intent(getActivity(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                       //Intent donut = new Intent(getActivity(), Kunde.class);
                     // startActivity(donut);
                       break;
                    case 1:
                        Intent cookie = new Intent(getActivity(), Managu.class);
                        startActivity(cookie);
                        break;

                }
            }
        });



        return accountadapter;
    }
}
