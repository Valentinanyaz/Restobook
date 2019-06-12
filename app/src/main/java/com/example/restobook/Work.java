package com.example.restobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Work extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
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
        if (item.getItemId() == R.id.menu_contacts) {
            Intent intent = new Intent(this, Contact.class);
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
