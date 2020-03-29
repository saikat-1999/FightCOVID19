package com.applex.fightcovid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    LinearLayout masks;
    LinearLayout myths;
    LinearLayout parenting;
    LinearLayout work;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener( this);

        masks = findViewById(R.id.masks);

        masks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),mask.class);
                startActivity(intent);

            }
        });

        myths = findViewById(R.id.myths);

        myths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),myth.class);
                startActivity(intent);
            }
        });

        work=findViewById(R.id.work);

//        work.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),work.class);
//                startActivity(intent);
//
//            }
//        });

        parenting=findViewById(R.id.parenting);

        parenting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),healthyparenting.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.guide_child) {
            // Handle the camera action
            Intent intent=new Intent(HomeActivity.this,children.class);
            startActivity(intent);
        }

        else if (id==R.id.stats) {
            Intent intent = new Intent(HomeActivity.this,statistics.class);
            intent.putExtra("choice","stats");
            startActivity(intent);
        }
        else if (id==R.id.donate) {
            Intent intent = new Intent(HomeActivity.this,statistics.class);
            intent.putExtra("choice","donate");
            startActivity(intent);
        }
        else if (id==R.id.state_stats) {
            Intent intent = new Intent(HomeActivity.this,statistics.class);
            intent.putExtra("choice","state");
            startActivity(intent);
        }
        else if(id==R.id.twitter) {
            Intent intent=new Intent(HomeActivity.this,twitter.class);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
