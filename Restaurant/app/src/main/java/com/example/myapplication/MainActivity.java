package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> res_name, res_location, res_phone, res_description, res_rating ;

    //ArrayList<Restaurant> tempList;


    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);

        res_name = new ArrayList<>();
        res_location = new ArrayList<>();
        res_phone = new ArrayList<>();
        res_description = new ArrayList<>();
        res_rating = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this,this, res_name, res_location, res_phone, res_description, res_rating);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    void storeDataInArrays()
    {
        Cursor cursor = myDB.readAllData();

        while (cursor.moveToNext())
        {
            res_name.add(cursor.getString(0));
            res_location.add(cursor.getString(1));
            res_phone.add(cursor.getString(2));
            res_description.add(cursor.getString(3));
            res_rating.add(cursor.getString(4));
        }

    }



}