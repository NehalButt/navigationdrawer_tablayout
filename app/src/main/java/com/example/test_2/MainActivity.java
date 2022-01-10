package com.example.test_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navbar;
    Toolbar toolbar;
    TabLayout tab;
    ActionBarDrawerToggle hamburger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navbar = (NavigationView) findViewById(R.id.navbar);
        tab = (TabLayout) findViewById(R.id.tab);

        hamburger = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(hamburger);
        hamburger.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_circle_left_24);
        Main main = new Main();
        FragmentTransaction mainchange = getSupportFragmentManager().beginTransaction();
        mainchange.replace(R.id.placeholder , main).commit();
        navbar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.files:
                        Main main = new Main();
                        FragmentTransaction mainchange = getSupportFragmentManager().beginTransaction();
                        mainchange.replace(R.id.placeholder , main).commit();
                        break;
                }
                return true;
            }
        });
        drawerLayout.closeDrawer(GravityCompat.START);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab Tab = new tab();
                        FragmentTransaction tabchange = getSupportFragmentManager().beginTransaction();
                        tabchange.replace(R.id.placeholder , Tab);
                        break;
            }}

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}