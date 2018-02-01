package com.powergeninfotech.iak_beginner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private Button btn_cancel;
    private Button btn_login;

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_login = findViewById(R.id.btn_login);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Button Ditekan", Toast.LENGTH_SHORT).show();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    et_username.setError("G Boleh Kosong mas");
                }

                if(TextUtils.isEmpty(password)) {
                    et_password.setError("G Boleh Kosong juga mas");
                }

                if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra(MainActivity.USERNAME, username);
                    intent.putExtra(MainActivity.PASSWORD, password);

                    finish();
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "Username dan Passwordnya Salah Mas", Toast.LENGTH_SHORT).show();

                    et_username.getText().clear();
                    et_password.getText().clear();
                }

            }
        });
    }
}
