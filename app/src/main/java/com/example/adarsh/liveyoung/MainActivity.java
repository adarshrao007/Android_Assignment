package com.example.adarsh.liveyoung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

public class MainActivity extends AppCompatActivity {

    EditText Username,Password;
    Button Login,Sinup;
    com.example.adarsh.liveyoung.DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.User);
        Password = (EditText) findViewById(R.id.Pass);

        Login = (Button)findViewById(R.id.Login);
        Sinup = (Button)findViewById(R.id.Sinup);


        myDb = new com.example.adarsh.liveyoung.DatabaseHelper(this);


        sinUP();
        logIn();


    }

    public boolean flag = false;
    public void logIn() {
        Login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {



                Cursor res = myDb.getData();
                while (res.moveToNext()) {
                    if (res.getString(0).equals(Username.getText().toString()) && res.getString(1).equals(Password.getText().toString())) {


                        flag = true;
                        Intent i = new Intent(MainActivity.this, Main4Activity.class);
                        i.putExtra("name",Username.getText().toString());
                        startActivity(i);

                        Username.setText("");
                        Password.setText("");

                        Toast.makeText(getApplicationContext(), "Log In Successful......", Toast.LENGTH_LONG).show();
                    }
                }

                if(!flag)

                {

                    Toast.makeText(getApplicationContext(), "Username or Password Incorrect", Toast.LENGTH_LONG).show();

                }

            }






        });
    }

    public void sinUP() {
        Sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(k);


            }
        });
    }


}
