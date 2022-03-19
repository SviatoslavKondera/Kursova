package com.example.mylnu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mylnu.databinding.ActivityNavigBinding;
import android.widget.TextView;


public class NavigAct extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private ActivityNavigBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityNavigBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavig.toolbar);
        binding.appBarNavig.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendmail(view);
                /*Snackbar.make(view, "Лист в підтримку надіслано.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navig);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        /*final TextView  textView = (TextView) findViewById(R.id.app_bar_navig);
        Intent intent = getIntent();
        String mystery = intent.getStringExtra("username");
        textView.setText(mystery);*/
        /*
        NavigationView navigationView2 = (NavigationView) findViewById(R.id.nav_header_navig);
        View headerView = navigationView2.getHeaderView(1);
        TextView navUsername = (TextView) headerView.findViewById(R.id.textView);
        navUsername.setText("Your Text Here");*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navig, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navig);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void sendmail(View view) {

        //QWerty123_45
        //mylnu.service@gmail.com
        String[] TO_EMAILS = {"mylnu.service@gmail.com"};


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);
        intent.putExtra(Intent.EXTRA_SUBJECT, "My LNU підтримка");
        startActivity(Intent.createChooser(intent, "Виберіть додаток для надсилання"));

    }
}