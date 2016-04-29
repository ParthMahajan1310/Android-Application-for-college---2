package com.example.parth.restart;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Page2 extends ActionBarActivity {
    EditText ed;
    Spinner sp1,sp2;
    int c=1;
    String st1,st2,st3,name,course,sem;
    String s1[]={"<--SELECT-->","CSE","MEC","CIVIL","ECE"};
    String s2[]={"<--SELECT-->","1st","2nd","3rd","4th"};
    Button sub;
    database stddb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.hide();
        stddb=new database(getApplicationContext());

        ed=(EditText)findViewById(R.id.editText);
        sub=(Button)findViewById(R.id.button);
        sp1=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> array1=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,s1);
        sp1.setAdapter(array1);


        sp2=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> array2=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,s2);
        sp2.setAdapter(array2);
        

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsetred = stddb.insetData(ed.getText().toString(),sp1.getSelectedItem().toString() ,sp2.getSelectedItem().toString());
                if (isInsetred == true) {

                    //Toast.makeText(getApplicationContext(), "Data is Inserted"+st1+st2+st3, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Data is not Inserted", Toast.LENGTH_LONG).show();
                }

                Cursor result = stddb.getAllData();
                StringBuffer buffer=new StringBuffer();
                String s[];
                //result.moveToFirst();
                while(result.moveToNext())
                {
                    name=result.getString(0);
                    course=result.getString(1);
                    sem=result.getString(2);
                }
                if(result.getCount()==0) {
                    Toast.makeText(getApplicationContext(), "no data found ", Toast.LENGTH_LONG).show();
                }
                else
                {
                  Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();

                }


                Intent intent1 = new Intent(Page2.this, home.class);
                intent1.putExtra("name", name);
                intent1.putExtra("course", course);
                intent1.putExtra("sem", sem);
                startActivity(intent1);





            }
        });


    }


}
