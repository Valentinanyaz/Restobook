package com.example.restobook;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:+79150658064")));
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;

            default:
                break;
        }
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_phone:
                int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            123);
                } else {
                    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+"+79150658064")));
                }
                break;
            default:
                break;
        }
        switch (v.getId()) {
            case R.id.btn_gmap:
                String geoUriString = "geo:0,0?q=москва+финансовый+университет+щербаковская?z=8";
                Uri geo = Uri.parse(geoUriString);
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, geo);

                if (geoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(geoIntent);
                }
                break;
            default:

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_main) {
            Intent intent = new Intent(this, MainPage.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.menu_map) {
            Intent intent = new Intent(this, Map.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.menu_book) {
            Intent intent = new Intent(this, Book.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.menu_personal) {
            Intent intent = new Intent(this, Personal.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.menu_info) {
            Intent intent = new Intent(this, Info.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.menu_exit) {
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
        return false;
    }
}
