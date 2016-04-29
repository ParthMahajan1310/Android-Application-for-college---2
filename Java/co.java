package com.example.parth.restart;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class co extends ActionBarActivity implements AdapterView.OnItemClickListener {
Button btn1,btn2,btn3,btn4;
    String name,course,sem;
    public DrawerLayout drawerlayout;
    public ListView list;
    public CustomAdapter ad;
    public ActionBarDrawerToggle drawerListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co);
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009999")));
        btn1=(Button)findViewById(R.id.button2);
        btn2=(Button)findViewById(R.id.button3);
        btn3=(Button)findViewById(R.id.button4);
        btn4=(Button)findViewById(R.id.button5);
        name=getIntent().getStringExtra("name");
        course=getIntent().getStringExtra("course");
        sem=getIntent().getStringExtra("sem");
        ab.setTitle("User "+name);
        String[] courses={"Home","TimeTable","Depart Updates","Acd Calender","ChangeDetails"};
        Integer[] images={R.drawable.home,R.drawable.time,R.drawable.up1,R.drawable.cal1,R.drawable.gdgu_icon};

        drawerlayout=(DrawerLayout)findViewById(R.id.drawer_Layout);
        drawerListener=new ActionBarDrawerToggle(this,drawerlayout,R.string.openDrawer,R.string.closeDrawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerlayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list=(ListView)findViewById(R.id.Left_drawer);
        ad=new CustomAdapter(this,courses,images);
        list.setAdapter(ad);
        list.setOnItemClickListener(this);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(co.this, LV.class);
                intent.putExtra("bn",1);
                intent.putExtra("name", name);
                intent.putExtra("course", course);
                intent.putExtra("sem", sem);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(co.this,LV.class);
                intent.putExtra("bn",2);
                intent.putExtra("name", name);
                intent.putExtra("course", course);
                intent.putExtra("sem", sem);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(co.this,LV.class);
                intent.putExtra("bn",3);
                intent.putExtra("name", name);
                intent.putExtra("course", course);
                intent.putExtra("sem", sem);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(co.this,LV.class);
                intent.putExtra("bn",4);
                intent.putExtra("name", name);
                intent.putExtra("course", course);
                intent.putExtra("sem", sem);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerListener.onConfigurationChanged(newConfig);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int p=position;
        if(p==0)
        {
            Intent intent=new Intent(co.this,home.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==1)
        {
            Intent intent=new Intent(co.this,time.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==2)
        {
            Intent intent=new Intent(co.this,depart.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==3)
        {
            Intent intent=new Intent(co.this,acd.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==4)
        {
            Intent intent=new Intent(co.this,Page2.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerListener.onOptionsItemSelected(item))
        {
            return true;
        }

        switch(item.getItemId())
        {
            case R.id.Settings:
                Intent in=new Intent(this,Page2.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(), "Settings Selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.Admission:
                Intent iin=new Intent(this,Admission.class);
                startActivity(iin);
                Toast.makeText(getApplicationContext(), "Admission Selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.exit:
                finish();

                return true;
        }
        return true;
    }



}
