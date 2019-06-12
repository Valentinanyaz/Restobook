package com.example.restobook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private TextView loginLocked;
    private TextView attempts;
    private TextView numberOfAttempts;
    int numberOfRemainingLoginAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Связываемся с элементами нашего интерфейса:
        username = (EditText) findViewById(R.id.edit_user);
        password = (EditText) findViewById(R.id.edit_password);
        login = (Button) findViewById(R.id.btn_enter);
        loginLocked = (TextView) findViewById(R.id.login_locked);
        attempts = (TextView) findViewById(R.id.attempts);
        numberOfAttempts = (TextView) findViewById(R.id.number_of_attempts);
        numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reg:
                Intent intent = new Intent(this, Reg.class);
                startActivity(intent);
                break;
            default:
        }
        switch (v.getId()) {
            case R.id.btn_enter:
                // Если введенные логин и пароль будут словом "admin",
                // показываем Toast сообщение об успешном входе:
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();

                    // Выполняем переход на другой экран:
                    Intent intent = new Intent(MainActivity.this, MainPage.class);
                    startActivity(intent);
                }

                // В другом случае выдаем сообщение с ошибкой:
                else {
                    Toast.makeText(getApplicationContext(), "Неправильные данные!", Toast.LENGTH_SHORT).show();
                    numberOfRemainingLoginAttempts--;

                    // Делаем видимыми текстовые поля, указывающие на количество оставшихся попыток:
                    attempts.setVisibility(View.VISIBLE);
                    numberOfAttempts.setVisibility(View.VISIBLE);
                    numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

                    // Когда выполнено 3 безуспешных попытки залогиниться,
                    // делаем видимым текстовое поле с надписью, что все пропало и выставляем
                    // кнопке настройку невозможности нажатия setEnabled(false):
                    if (numberOfRemainingLoginAttempts == 0) {
                        login.setEnabled(false);
                        loginLocked.setVisibility(View.VISIBLE);
                        loginLocked.setBackgroundColor(Color.RED);
                        loginLocked.setText("Вход заблокирован!!!");
                        break;


                    }
                }


        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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