package com.example.faizrehman.campus_recruitment_system.ui.Event;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.faizrehman.campus_recruitment_system.Adapter.TabAdapter;
import com.example.faizrehman.campus_recruitment_system.R;
import com.example.faizrehman.campus_recruitment_system.ui.Company.Appr_event_fragment;
import com.example.faizrehman.campus_recruitment_system.ui.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by Gaurav Narwani on 25-03-2018.
 */


@SuppressLint("Registered")
public class Event_Activity extends AppCompatActivity {


    private ViewPager viewPager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        TabLayout tabLayout1 = (TabLayout) findViewById(R.id.tab_layout1);
        viewPager1 = (ViewPager) findViewById(R.id.view_pager1);
        ArrayList<Fragment> fragmentArrayListl = new ArrayList<>();
        tabLayout1.addTab(tabLayout1.newTab().setText("Event Creater"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Approved Events"));
        Event_fragment event_fragment = new Event_fragment();
        Appr_event_fragment appr_event_fragment = new Appr_event_fragment();
        fragmentArrayListl.add(event_fragment);
        fragmentArrayListl.add(appr_event_fragment);
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), fragmentArrayListl);
        viewPager1.setAdapter(adapter);
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        viewPager1.setOffscreenPageLimit(0);

        tabLayout1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(Event_Activity.this);
                builder.setTitle("Exit !!");
                builder.setMessage("you want Logout..??");
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(Event_Activity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setPositiveButton("Back", null);
                builder.create().show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);


        return true;
    }
}