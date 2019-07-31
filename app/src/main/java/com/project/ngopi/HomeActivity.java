package com.project.ngopi;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    String[] permissions = new String[]{
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION};

    private static final int REQUEST_MULTIPLE_PERMISSIONS = 117;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        boolean perms = checkPermissions();
        if (perms) {


            if (savedInstanceState != null) {

            }
        }
    }


    public void recom(View view) {
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);


    }

    public void designer(View view) {
        Intent intent = new Intent(HomeActivity.this, MapsActivity.class);
        startActivity(intent);

    }

    public void about (View view) {
        Intent intent = new Intent(HomeActivity.this, About.class);
        startActivity(intent);

    }


        private boolean checkPermissions () {
            int result;
            List<String> listPermissionsNeeded = new ArrayList<>();
            for (String p : permissions) {
                result = ContextCompat.checkSelfPermission(this, p);
                if (result != PackageManager.PERMISSION_GRANTED) {
                    listPermissionsNeeded.add(p);
                }
            }
            if (!listPermissionsNeeded.isEmpty()) {
                ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_MULTIPLE_PERMISSIONS);
                return false;
            }
            return true;
        }
    }


