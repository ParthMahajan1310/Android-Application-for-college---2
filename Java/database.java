package com.example.parth.restart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="student";
    public static final String STD_NAME="NAME";
    public static final String STD_Course="COURSE";
    public static final String STD_SEM="SEM";

    public database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        // TODO Auto-generated constructor stub
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table if not exists student (NAME TEXT,COURSE TEXT,SEM TEXT)");
        //db.execSQL("create table if not exists Emp(ID integer primary key,NAME varchar(20),POST varchar(11),SALARY,VARCHAR)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }
    public boolean insetData(String name,String course,String sem)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(STD_NAME, name);
        values.put(STD_Course, course);
        values.put(STD_SEM, sem);
        long result=db.insert(TABLE_NAME, null, values);
        if(result==-1){
            return false;
        }
        else
            return true;



    }

    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("select * from "+TABLE_NAME, null);
        return data;

    }

}
