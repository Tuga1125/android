package com.example.onlinefoodorder.Activity;

import android.app.Notification;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.example.onlinefoodorder.Channel.CreateChannel;
import com.example.onlinefoodorder.MainActivity;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.Sensors.ProximitySensor_Add;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class navbar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static NavigationView navigationView;
    TextView txtFood, tvNext, navUser, navEmail;
    Button btnAddFooditems, btnViewFooditems;
    Button BtnSEarch;
    DrawerLayout drawer;


    private NotificationManagerCompat notificationManagerCompat;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbar);

        drawer = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Dashboard");
        setSupportActionBar(toolbar);
        //FloatingActionButton addShowButton = findViewById(R.id.);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        txtFood = findViewById(R.id.txtFood);

        txtFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navbar.this, OrderItemActivity.class));
            }
        });

        tvNext = findViewById(R.id.tvNext);

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navbar.this, SearchActivity.class));
            }
        });

        btnAddFooditems = findViewById(R.id.btnAddFooditems);

        btnAddFooditems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navbar.this, FoodItemsActivity.class));
            }
        });

        btnViewFooditems = findViewById(R.id.btnViewFooditems);

        btnViewFooditems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navbar.this, ViewFoodItemsActivity.class));
            }
        });

        BtnSEarch = findViewById(R.id.BtnSEarch);

        BtnSEarch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(navbar.this, SearchActivity.class));
            }
        });



//        btnProx.findViewById(R.id.btnProx);
//
//        btnProx.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(navbar.this, ProximitySensor_Add.class));
//            }
//        });
        inflateHeader();



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            UserLogout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private View header;
    private void inflateHeader(){
        header = navigationView.getHeaderView(0);
        navUser  = header.findViewById(R.id.navUser);
        navEmail  = header.findViewById(R.id.navEmail);

        navUser.setText(MainActivity.username + " ("+ MainActivity.loggedInUserType+") ");
        navEmail.setText(MainActivity.email);
//        Global.alert(getApplicationContext(),Global.loggedInUserId);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void UserLogout(){
        MainActivity.logout();
        startActivity(new Intent(navbar.this,LoginScreenActivity.class));
        finish();
    }


}