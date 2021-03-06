package com.applex.fightcovid_19;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout masks;
    LinearLayout myths;
    LinearLayout parenting;
    LinearLayout work;
    LinearLayout protect;


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SWITCH_PREF = "switch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("COVID-19");
        setSupportActionBar(toolbar);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("MyNotifications","MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        ////////////////////NAV DRAWER/////////////////
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener( this);

        Menu menu = navigationView.getMenu();
        MenuItem menuItem = menu.findItem(R.id.nav_switch);

        Switch sw = menuItem.getActionView().findViewById(R.id.switchh);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        sw.setChecked(sharedPreferences.getBoolean(SWITCH_PREF, false));

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                @SuppressLint("CommitPrefEdits")
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(SWITCH_PREF, isChecked);
                editor.apply();

                if(isChecked) {

                    final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                    builder.setTitle("Reminder")
                            .setMessage("By switching on the reminder, you will be receiving notifications for maintaining personal hygiene and adopting precautionary measures, 5 times a day. ")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setCancelable(true)
                            .show();

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY,02);
                    calendar.set(Calendar.MINUTE,16);
                    calendar.set(Calendar.SECOND,00);

                    Intent intent = new Intent(getApplicationContext(),Notification_receiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                }
            }
        });

        ////////////////////NAV DRAWER/////////////////


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

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),workplace.class);
                startActivity(intent);
            }
        });

        parenting=findViewById(R.id.parenting);

        parenting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),healthyparenting.class);
                startActivity(intent);

            }
        });

        protect=findViewById(R.id.protect);

        protect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),basicprotection.class);
                startActivity(intent);

            }
        });
    }



    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.guide_child) {
            Intent intent=new Intent(HomeActivity.this,children.class);
            startActivity(intent);
        }
//        else if(id == R.id.nav_switch) {
//            NavigationView navigationView = findViewById(R.id.nav_view);
////            Menu menu = navigationView.getMenu();
////            menu.findItem(R.id.nav_switch);
//            Switch sw = menuItem.getActionView().findViewById(R.id.switchh);
//
//            ////////////////SHARED PREFERENCES/////////////
//            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//
//            editor.putBoolean(SWITCH_PREF, sw.isChecked());
//            ////////////////SHARED PREFERENCES/////////////
//
//            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked) {
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.set(Calendar.HOUR_OF_DAY,23);
//                    calendar.set(Calendar.MINUTE,34);
//                    calendar.set(Calendar.SECOND,00);
//
//                    Intent intent = new Intent(getApplicationContext(),Notification_receiver.class);
//                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
//                    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
//                }
//            }
//        });
//
//        }

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
        else if(id==R.id.nav_slideshow) {
            Intent intent=new Intent(HomeActivity.this,WorkHome.class);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
