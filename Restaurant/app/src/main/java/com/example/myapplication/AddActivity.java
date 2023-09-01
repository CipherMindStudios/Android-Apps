package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText name_input, location_input, phone_input, description_input, rating_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = findViewById(R.id.name_input);
        location_input = findViewById(R.id.location_input);
        phone_input = findViewById(R.id.phone_input);
        description_input = findViewById(R.id.description_input);
        rating_input = findViewById(R.id.rating_input);

        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(
                        name_input.getText().toString().trim(),
                        location_input.getText().toString().trim(),
                        Integer.valueOf(phone_input.getText().toString().trim()),
                        description_input.getText().toString().trim(),
                        Integer.valueOf(rating_input.getText().toString().trim())

                );
            }
        });
    }
}