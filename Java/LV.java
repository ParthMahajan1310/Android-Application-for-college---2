package com.example.parth.restart;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class LV extends ActionBarActivity implements AdapterView.OnItemClickListener {
    String name, course, sem;
            static String st1="";
    ImageView i;
    int bn;
    public DrawerLayout drawerlayout;
    public ListView list;
    public CustomAdapter ad;
    public ActionBarDrawerToggle drawerListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv);
        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009999")));
        ListView lv;
        i=(ImageView)findViewById(R.id.imageView2);
        Integer[] prgmImages = {R.drawable.gdgu_icon, R.drawable.gdgu_icon, R.drawable.gdgu_icon, R.drawable.gdgu_icon, R.drawable.gdgu_icon, R.drawable.gdgu_icon, R.drawable.gdgu_icon};
        final String[] cs4 = {"DBMS", "CAO", "NumericalMethods", "SoftwareEngineering", "ProgrammingLanguages", "So/Phy", "TheoryOfComputaion"};
        String[] cs3 = {"Let Us33 C", "Let Us C", "Let Us C", "Let Us C", "Let Us C", "Let Us C"};
        String[] courses={"Home","TimeTable","Depart Updates","Acd Calender","ChangeDetails"};
        Integer[] images={R.drawable.home,R.drawable.time,R.drawable.up1,R.drawable.cal1,R.drawable.gdgu_icon};


        name = getIntent().getStringExtra("name");
        course = getIntent().getStringExtra("course");
        sem = getIntent().getStringExtra("sem");
        bn=getIntent().getIntExtra("bn",0);

        if (bn==1)
        {
            i.setImageResource(R.drawable.ln);
        }
        else if (bn==2){
            i.setImageResource(R.drawable.qu);
        }
        else if (bn==3){
            i.setImageResource(R.drawable.ass);
        }
        else if (bn==4){
            i.setImageResource(R.drawable.lab);
        }



        ab.setTitle("User "+name);


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

        lv = (ListView) findViewById(R.id.listView);

        if (course.equals("CSE") && sem.equals("4th")) {
            lv.setAdapter(new CustomAdapter(LV.this, cs4, prgmImages));
        } else
            lv.setAdapter(new CustomAdapter(this, cs3, prgmImages));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(cs4[position].equals("DBMS")){
                Intent intent=new Intent(getApplicationContext(),web.class);
                    intent.putExtra("name", name);
                    intent.putExtra("course", course);
                    intent.putExtra("sem", sem);
                startActivity(intent);}

                else if(cs4[position].equals("SoftwareEngineering")&&bn==1){
                    String url="https://sites.google.com/site/segdgu/file-cabinet";
                    Intent intent=new Intent(getApplicationContext(),web.class);
                    intent.putExtra("name", name);
                    intent.putExtra("url",url);
                    intent.putExtra("course", course);
                    intent.putExtra("sem", sem);
                    startActivity(intent);}

                else if(cs4[position].equals("SoftwareEngineering")&&bn==2){
                    String url="https://sites.google.com/site/segdgu/project-definition";
                    Intent intent=new Intent(getApplicationContext(),web.class);
                    intent.putExtra("name", name);
                    intent.putExtra("url",url);
                    intent.putExtra("course", course);
                    intent.putExtra("sem", sem);
                    startActivity(intent);}

                else if(cs4[position].equals("SoftwareEngineering")&&bn==3){
                    String url="https://sites.google.com/site/segdgu/home/assignments";
                    Intent intent=new Intent(getApplicationContext(),web.class);
                    intent.putExtra("name", name);
                    intent.putExtra("url",url);
                    intent.putExtra("course", course);
                    intent.putExtra("sem", sem);
                    startActivity(intent);}

                else if(cs4[position].equals("SoftwareEngineering")&&bn==4){
                    String url="https://sites.google.com/site/segdgu/project-updates/labinternal-27-30april";
                    Intent intent=new Intent(getApplicationContext(),web.class);
                    intent.putExtra("name", name);
                    intent.putExtra("url",url);
                    intent.putExtra("course", course);
                    intent.putExtra("sem", sem);
                    startActivity(intent);}
            }

        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
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
            Intent intent=new Intent(LV.this,home.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==1)
        {
            Intent intent=new Intent(LV.this,time.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==2)
        {
            Intent intent=new Intent(LV.this,depart.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==3)
        {
            Intent intent=new Intent(LV.this,acd.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
        else if(p==4)
        {
            Intent intent=new Intent(LV.this,Page2.class);
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("sem", sem);
            startActivity(intent);
        }
}
}





