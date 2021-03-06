package com.illinois.lavanyap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Resource_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respg2);

        ImageButton water_button = findViewById(R.id.water_button);
        ImageButton paper_button = findViewById(R.id.paper_button);
        ImageButton plastic_button = findViewById(R.id.plastic_button);
        ImageButton misc_button = findViewById(R.id.misc_button);


        Bundle b = this.getIntent().getExtras();
        final String user = b.getString("username");

        water_button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Resource_Page.this.getApplicationContext(), List_of_Projects.class);
                startIntent.putExtra("resource", "water");
                startIntent.putExtra("username", user);
                Resource_Page.this.startActivity(startIntent);


            }
        });
        plastic_button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Resource_Page.this.getApplicationContext(), List_of_Projects.class);
                startIntent.putExtra("resource", "plastic");
                startIntent.putExtra("username", user);
                Resource_Page.this.startActivity(startIntent);


            }
        });
        paper_button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Resource_Page.this.getApplicationContext(), List_of_Projects.class);
                startIntent.putExtra("resource", "paper");
                startIntent.putExtra("username", user);
                Resource_Page.this.startActivity(startIntent);


            }
        });
        misc_button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Resource_Page.this.getApplicationContext(), List_of_Projects.class);
                startIntent.putExtra("resource", "misc");
                startIntent.putExtra("username", user);
                Resource_Page.this.startActivity(startIntent);


            }
        });


            //BottomoNavigavtion code
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Toast.makeText(Resource_Page.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent startIntent = new Intent(getApplicationContext(), User_Profile.class);
                        startIntent.putExtra("username", user);
                        startActivity(startIntent);
                        break;
                    case R.id.navigation_resource:
                        Toast.makeText(Resource_Page.this, "Resources", Toast.LENGTH_SHORT).show();
                        Intent resintent = new Intent(getApplicationContext(), Resource_Page.class);
                        resintent.putExtra("username", user);
                        startActivity(resintent);
                        break;
                    case R.id.navigation_ecotips:
                        Toast.makeText(Resource_Page.this, "EcoTips", Toast.LENGTH_SHORT).show();
                        Intent ecotip = new Intent(getApplicationContext(), Ecotip.class);
                        ecotip.putExtra("username", user);
                        startActivity(ecotip);
                        break;
                    case R.id.overflow:
                        PopupMenu popup = new PopupMenu(Resource_Page.this, findViewById(R.id.overflow));
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.settings, popup.getMenu());
                        popup.show();

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.help:
                                    Toast.makeText(Resource_Page.this, "Help", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.action_settings:
                                    Toast.makeText(Resource_Page.this, "Settings", Toast.LENGTH_SHORT).show();
                                    Intent settingintent = new Intent(getApplicationContext(), SettingsActivity.class);
                                    startActivity(settingintent);
                                    break;
                                case R.id.info:
                                    Toast.makeText(Resource_Page.this, "Info", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.logout:
                                    Intent loginintent = new Intent(getApplicationContext(), Login.class);
                                    startActivity(loginintent);
                                    break;

                            }
                                return true;
                        }
                        });

                }

                return false;
            }
        });


        }
}
