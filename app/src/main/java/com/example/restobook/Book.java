package com.example.restobook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Book extends AppCompatActivity implements View.OnClickListener {
    EditText ed_person;
    EditText ed_date;
    EditText ed_time;
    EditText ed_hall;
    EditText ed_table;
    final String Saved_text1="saved text1";
    final String Saved_text2="saved text2";
    final String Saved_text3="saved text3";
    final String Saved_text4="saved text4";
    final String Saved_text5="saved text5";
    SharedPreferences spref;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Button btn_map = (Button) findViewById(R.id.btn_map);
        Button btn_booking = (Button) findViewById(R.id.btn_booking);

        ed_person = (EditText) findViewById(R.id.ed_person);
        ed_date = (EditText) findViewById(R.id.ed_date);
        ed_time = (EditText) findViewById(R.id.ed_time);
        ed_hall = (EditText) findViewById(R.id.ed_hall);
        ed_table = (EditText) findViewById(R.id.ed_table);

        btn_map.setOnClickListener(this);
        btn_booking.setOnClickListener(this);

        loadText();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void onClick(View v) {
    switch (v.getId()) {
        case R.id.btn_map:
            Intent intent = new Intent(this, Map.class);
            startActivity(intent);
            break;
        default:
    }
        switch (v.getId()) {
            case R.id.btn_booking:
                saveText();
                loadText();
                Intent intent = new Intent(this, Personal.class);
                intent.putExtra("person", ed_person.getText().toString());
                intent.putExtra("date", ed_date.getText().toString());
                intent.putExtra("time", ed_time.getText().toString());
                intent.putExtra("hall", ed_hall.getText().toString());
                intent.putExtra("table", ed_table.getText().toString());
                startActivity(intent);
                break;
            default:
        }
}
    void loadText() {
        spref=getPreferences(MODE_PRIVATE);
        String savedText1=spref.getString(Saved_text1,"");
        String savedText2=spref.getString(Saved_text2,"");
        String savedText3=spref.getString(Saved_text3,"");
        String savedText4=spref.getString(Saved_text4,"");
        String savedText5=spref.getString(Saved_text5,"");
        ed_person.setText(savedText1);
        ed_date.setText(savedText2);
        ed_time.setText(savedText3);
        ed_hall.setText(savedText4);
        ed_table.setText(savedText5);
        // Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }


    void saveText() {
        spref=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed=spref.edit();
        ed.putString(Saved_text1, ed_person.getText().toString());
        ed.commit();
        ed.putString(Saved_text2, ed_date.getText().toString());
        ed.commit();
        ed.putString(Saved_text3, ed_time.getText().toString());
        ed.commit();
        ed.putString(Saved_text4, ed_hall.getText().toString());
        ed.commit();
        ed.putString(Saved_text5, ed_table.getText().toString());
        ed.commit();
        //   Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
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

