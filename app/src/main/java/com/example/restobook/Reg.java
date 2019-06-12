package com.example.restobook;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.restobook.R;

public class Reg extends Activity implements OnClickListener {

    final String LOG_TAG = "myLogs";

    Button btn_regnew, btnRead;
    EditText ed_name, ed_login, ed_pas;

    DBHelper dbHelper;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        btn_regnew = (Button) findViewById(R.id.btn_regnew);
        btn_regnew.setOnClickListener(this);



        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_login = (EditText) findViewById(R.id.ed_login);
        ed_pas = (EditText) findViewById(R.id.ed_pas);

        // создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(this);
    }


    @Override
    public void onClick(View v) {

        // создаем объект для данных
        ContentValues cv = new ContentValues();

        // получаем данные из полей ввода
        String name = ed_name.getText().toString();
        String login = ed_login.getText().toString();
        String pas = ed_pas.getText().toString();

        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        switch (v.getId()) {
            case R.id.btn_regnew:
                Log.d(LOG_TAG, "--- Insert in mytable: ---");
                // подготовим данные для вставки в виде пар: наименование столбца - значение

                cv.put("name", name);
                cv.put("login", login);
                cv.put("pas", pas);
                // вставляем запись и получаем ее ID
                long rowID = db.insert("mytable", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            break;
            default:


        }
        // закрываем подключение к БД
        dbHelper.close();
    }



    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "login text," + "pas text"+ ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
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

