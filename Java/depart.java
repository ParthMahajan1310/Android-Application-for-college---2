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
import android.widget.ListView;


public class depart extends ActionBarActivity implements AdapterView.OnItemClickListener {
    String name,course,sem;

    public DrawerLayout drawerlayout;
    public ListView list;
    public CustomAdapter ad;
    public ActionBarDrawerToggle drawerListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depart);
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009999")));

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

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerListener.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
            Intent intent=new Intent(this,home.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==1)
        {
            Intent intent=new Intent(this,time.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==2)
        {
            Intent intent=new Intent(this,depart.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==3)
        {
            Intent intent=new Intent(this,acd.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==4)
        {
            Intent intent=new Intent(this,Page2.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
    }

}
