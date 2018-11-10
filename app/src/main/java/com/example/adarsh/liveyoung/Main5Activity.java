package com.example.adarsh.liveyoung;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {
    com.example.adarsh.liveyoung.DatabaseHelper myDb;
    EditText SearchId;
    Button Search;
    ListView Lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        myDb = new com.example.adarsh.liveyoung.DatabaseHelper(this);

        SearchId = (EditText) findViewById(R.id.patientId);
        Search   = (Button) findViewById(R.id.search);

        search();

    }

    public void search() {
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res =myDb.getid(SearchId.getText().toString());


                if(SearchId.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter Valid ID",Toast.LENGTH_LONG).show();
                }
                else {

                    boolean flag =false;
                    StringBuffer buffer = new StringBuffer();

                    if (res.getCount() == 0) {
                        showMessage("Error", "Nothing Found");
                        return;
                    }


                    while (res.moveToNext()) {
                        if(res.getString(2).equals(SearchId.getText().toString()))
                        {
                            flag = true;

                            buffer.append("Patient First Name:" + res.getString(0) + "\n");
                            buffer.append("Patient Second Name::" + res.getString(1) + "\n");
                            buffer.append("Patient ID::" + res.getString(2) + "\n");
                            buffer.append("Patient Gender::" + res.getString(3) + "\n");
                            buffer.append("Patient Height::" + res.getString(4) + "\n");
                            buffer.append("Patient Weight::" + res.getString(5) + "\n");
                            buffer.append("Patient Blood Group::" + res.getString(6) + "\n");
                            buffer.append("Free Time::" + res.getString(7) + "\n");
                            buffer.append("Patient Email Id::" + res.getString(8) + "\n");



                            break;
                        }

                        else
                            flag = false;


                    }
                    if(flag){

                        showMessage("Data", buffer.toString());

                    }
                    else{

                        Toast.makeText(getApplicationContext(),"Please Check your ID",Toast.LENGTH_LONG).show();

                    }



                }
            }
        });
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
