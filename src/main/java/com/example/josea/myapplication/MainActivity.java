package com.example.josea.myapplication;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        //Intialization Button
/*
        btnClickMe = findViewById(R.id.floatingActionButton);

        btnClickMe.setOnClickListener(MainActivity.this);
        //Here MainActivity.this is a Current Class Reference (context)
*/
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }


    @Override
    public void onClick(View v) {
        btnClickMe.setText(getResources().getString(R.string.botonFoto));
        dispatchTakePictureIntent();
    }
}
