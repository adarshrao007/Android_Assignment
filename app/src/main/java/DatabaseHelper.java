
package com.example.adarsh.liveyoung;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adarsh on 05-11-2018.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="Registration.db";

    /*Table for sinup*/
    public static final String TABLE_NAME ="Sinup_table";
    //public static final String COL_1 ="ID";
    public static final String COL_2 ="Name";
    public static final String COL_3 ="User_Name";
    public static final String COL_4 ="Password";

    //Table for patient information
    public static final String TABLE_NAME1 ="Info_table";
    public static final String Info_COL_1 ="FName";
    public static final String Info_COL_2 ="SName";
    public static final String Info_COL_3 ="Id";
    public static final String Info_COL_4 ="Gender";
    public static final String Info_COL_5 ="Height";
    public static final String Info_COL_6 ="Weight";
    public static final String Info_COL_7 ="Bgroup";
    public static final String Info_COL_8 ="Ftime";
    public static final String Info_COL_9 ="Emailid";


    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME , null, 1);

        //SQLiteDatabase db =this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT NOT NULL, User_Name TEXT NOT NULL,  Password TEXT NOT NULL)");
        db.execSQL("create table "+TABLE_NAME1+ "( FName TEXT, SName TEXT, Id  INTEGER PRIMARY KEY ,  Gender TEXT,  Height INTEGER,  Weight INTEGER,  Bgroup TEXT,  Ftime TEXT,  EmailId TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);

    }
    public boolean inserData(String name, String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,username);
        contentValues.put(COL_4,password);
        long result =db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return  false;
        else
            return  true;
    }
    public boolean inserIntoData(String fname, String sname, String id, String gender, String height, String weight, String bgroup, String freetime, String emailid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Info_COL_1,fname);
        contentValues.put(Info_COL_2,sname);
        contentValues.put(Info_COL_3,id);
        contentValues.put(Info_COL_4,gender);
        contentValues.put(Info_COL_5,height);
        contentValues.put(Info_COL_6,weight);
        contentValues.put(Info_COL_7,bgroup);
        contentValues.put(Info_COL_8,freetime);
        contentValues.put(Info_COL_9,emailid);



        long result =db.insert(TABLE_NAME1,null,contentValues);
        if(result == -1)
            return  false;
        else
            return  true;
    }

    public Cursor getData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select User_Name,Password from "+TABLE_NAME,null);
        return res;

    }

    public Cursor checkid(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select Id from "+TABLE_NAME1 ,null);
        return res;

    }



    public Cursor getid(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME1 +" where "+Info_COL_3+"=id ",null);
        return res;

    }

}