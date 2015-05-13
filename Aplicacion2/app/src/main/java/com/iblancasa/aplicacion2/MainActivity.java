package com.iblancasa.aplicacion2;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.iblancasa.aplicacion1.R;


public class MainActivity extends ActionBarActivity {


    //Array with titles
    String TITLES[] = {"Inicio","Soporte","Ver otra","Opción","Similares"};

    //Associated icons
    int ICONS[] = {R.drawable.ic_1,R.drawable.ic_2,R.drawable.ic_3,R.drawable.ic_4,R.drawable.ic_5};


    //Name to show
    String NAME = "Israel Blancas";

    //Email to show
    String EMAIL = "iblancasa [@] gmail.com";

    //User to show
    int PROFILE = R.drawable.user;


    //Toolbar
    private Toolbar toolbar;

    //Declaration of RecyclerView
    RecyclerView RecyclerView;

    //Adapter for RecyclerView
    RecyclerView.Adapter Adapter;

    //Layout manager
    RecyclerView.LayoutManager LayoutManager;

    //Drawer Layout
    DrawerLayout Drawer;

    //Action Bar Drawer Toggle
    ActionBarDrawerToggle mDrawerToggle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the toolbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        RecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);


        RecyclerView.setHasFixedSize(true);//Fixed size for the RecyclerView

        Adapter = new AdapterDrawer(TITLES,ICONS,NAME,EMAIL,PROFILE);//New adapter

        RecyclerView.setAdapter(Adapter);//Set adapter

        LayoutManager = new LinearLayoutManager(this);//Layout Manager (linear)

        RecyclerView.setLayoutManager(LayoutManager);//Setting the layout manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);

        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,0,0){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //Code here will execute once drawer is opened by the user
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //Code here will execute once drawer is closed by the user
            }
        };

        Drawer.setDrawerListener(mDrawerToggle);//Add listener
        mDrawerToggle.syncState();              //Sync State of drawer

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Add items to toolbar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}