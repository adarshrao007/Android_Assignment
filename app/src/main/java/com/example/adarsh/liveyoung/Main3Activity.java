package com.example.adarsh.liveyoung;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    com.example.adarsh.liveyoung.DatabaseHelper myDb;
    EditText Name, Username, Password, Id;
    Button Sinup, View, Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        myDb = new com.example.adarsh.liveyoung.DatabaseHelper(this);

        Name = (EditText) findViewById(R.id.fname);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.Pass);
        // Id = (EditText)findViewById(R.id.id);

        Sinup = (Button) findViewById(R.id.sinup);
        //View = (Button) findViewById(R.id.view);
        Cancel = (Button) findViewById(R.id.cancel);

        sinUp();
        cancel();
        //view();

    }


    private void cancel() {
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name.setText("");
                Username.setText("");
                Password.setText("");
                Intent o = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(o);
            }
        });
    }

    private void sinUp() {
        Sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (Name.getText().toString().equals("") || Username.getText().toString().equals("") || Password.getText().toString().equals("")) {


                    Toast.makeText(getApplicationContext(), "Please Insert Data", Toast.LENGTH_LONG).show();
//                    Intent j = new Intent(getApplicationContext(),MainActivity.class);
//                    startActivity(j);
                    Name.setHintTextColor(Color.parseColor("#ffcc0000"));
                    Username.setHintTextColor(Color.parseColor("#ffcc0000"));
                    Password.setHintTextColor(Color.parseColor("#ffcc0000"));


                } else {

                    boolean isInserted = myDb.inserData(Name.getText().toString(), Username.getText().toString(), Password.getText().toString());

                    Intent j = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(j);
                    Toast.makeText(getApplicationContext(), "Successfully Signed Up", Toast.LENGTH_LONG).show();
                    finish();
                }


            }
        });

    }
}
//