package com.simonh.fit;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.simonh.fit.WorkoutFrag.WorkoutFragment;

//This is the main activity that opens first
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar is created here and used throughout all pag
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //opens up workout fragment within the main activity
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new WorkoutFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_workout);
        }



    }



    @Override //for when item on nav menu is clicked
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_workout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WorkoutFragment()).commit();
                drawer.closeDrawers();
                break;
            case R.id.nav_warmup:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WarmupFragment()).commit();
                drawer.closeDrawers();
                break;
            case R.id.nav_guide:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GuideFragment()).commit();
                drawer.closeDrawers();
                break;
            case R.id.nav_about:
                Toast.makeText(this, "This is the about FYCK THIS BULLSHIT", Toast.LENGTH_LONG).show();
                drawer.closeDrawers();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
