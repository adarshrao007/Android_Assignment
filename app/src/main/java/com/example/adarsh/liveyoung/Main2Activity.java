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

public class Main2Activity extends AppCompatActivity {

    com.example.adarsh.liveyoung.DatabaseHelper myDb;

    EditText PFname,PSname,PId,PGender,PHeight,PWeight,PBgroup,PFtime,PEmail;
    Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myDb = new com.example.adarsh.liveyoung.DatabaseHelper(this);

        PFname       = (EditText)findViewById(R.id.fname);
        PSname       = (EditText)findViewById(R.id.sname);
        PId          = (EditText)findViewById(R.id.id);
        PGender     = (EditText)findViewById(R.id.adress);
        PHeight          = (EditText)findViewById(R.id.phone);
        PWeight   = (EditText)findViewById(R.id.department);
        PBgroup       = (EditText)findViewById(R.id.doctor);
        PFtime       = (EditText)findViewById(R.id.diagnosis);
        PEmail  = (EditText)findViewById(R.id.condition);
     
     



        Update =(Button)findViewById(R.id.update);


        upDate();

    }



    public void upDate() {
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(PFname.getText().toString().equals("") || PId.getText().toString().equals("") || PGender.getText().toString().equals("") || PHeight.getText().toString().equals("")|| PWeight.getText().toString().equals("")|| PBgroup.getText().toString().equals("")|| PFname.getText().toString().equals("")){


                    Toast.makeText(getApplicationContext(),"Please Insert Data",Toast.LENGTH_LONG).show();

                   
                   
                   
                   
                   
                   
                   




                }
                else{

                    boolean flag =false;
                    Cursor res = myDb.checkid();

                    while (res.moveToNext()) {
                        if (res.getString(0).equals(PId.getText().toString()) || PId.getText().toString().equals("")) {

                            if(PId.getText().toString().equals("0")){

                                Toast.makeText(getApplicationContext(),"0 is not valid ",Toast.LENGTH_LONG).show();
                            }
                            flag = true;
                            PId.setHintTextColor(Color.parseColor("#ffcc0000"));


                        }

                    }
                    if(!flag ){
                        boolean isInserted = myDb.inserIntoData(PFname.getText().toString(),PSname.getText().toString(),PId.getText().toString(),PGender.getText().toString(),PHeight.getText().toString(),PWeight.getText().toString(),PBgroup.getText().toString(),PFtime.getText().toString(),PEmail.getText().toString());

                        Intent j = new Intent(getApplicationContext(),Main4Activity.class);
                        startActivity(j);
                        Toast.makeText(getApplicationContext(),"Successfully Added The Information ",Toast.LENGTH_LONG).show();
                        finish();

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "This Id Is Already Exist ", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "Please Enter Unique Id ", Toast.LENGTH_LONG).show();

                    }

                }





            }
        });
    }


}