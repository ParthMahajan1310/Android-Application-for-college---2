package com.example.parth.restart;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;

public class Page1 extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    database stddb;
    String name,course="",sem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        stddb=new database(getApplicationContext());

        Cursor result = stddb.getAllData();
          while(result.moveToNext())
        {
            name=result.getString(0);
            course=result.getString(1);
            sem=result.getString(2);
        }


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if(course.equals("")){
                    Intent i = new Intent(Page1.this, Select.class);
                startActivity(i);
                finish();}
                else
                {
                    Intent intent = new Intent(Page1.this, home.class);
                    intent.putExtra("name", name);
                    intent.putExtra("course", course);
                    intent.putExtra("sem", sem);

                    startActivity(intent);
                    finish();}

            }

        }, SPLASH_TIME_OUT);
    }

}
