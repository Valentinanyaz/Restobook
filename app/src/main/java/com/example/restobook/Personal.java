package com.example.restobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Personal extends AppCompatActivity {
    TextView tvperson;
    TextView tvdate;
    TextView tvtime;
    TextView tvhall;
    TextView tvtable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        tvperson = (TextView) findViewById(R.id.tvperson);
        tvdate = (TextView) findViewById(R.id.tvdate);
        tvtime = (TextView) findViewById(R.id.tvtime);
        tvhall = (TextView) findViewById(R.id.tvhall);
        tvtable = (TextView) findViewById(R.id.tvtable);

        // получаем Intent, который вызывал это Activity
        Intent intent = getIntent();

        String person = intent.getStringExtra("person");
        tvperson.setText("Количество персон: " + person);
        String date = intent.getStringExtra("date");
        tvdate.setText("Ваша дата: " + date);
        String time = intent.getStringExtra("time");
        tvtime.setText("Ваше время: " + time);
        String hall = intent.getStringExtra("hall");
        tvhall.setText("Ваш зал: " + hall);
        String table = intent.getStringExtra("table");
        tvtable.setText("Ващ столик №: " + table);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_change:
                Intent intent = new Intent(this, Book.class);
                startActivity(intent);
                break;
            default:

        }
        switch (v.getId()) {
            case R.id.btn_exit:
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
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
