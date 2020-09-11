package com.example.bandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.Login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username2 = username.getText().toString();
                String password2 = password.getText().toString();
                Toast.makeText(Login.this, "Username: " + username2 + "\n" + "Password: " + password2, Toast.LENGTH_SHORT).show();

                Intent gotoSearch = new Intent(Login.this, Search.class);
                startActivity(gotoSearch);

                username.setError(null);
                password.setError(null);
                if (Validation.isCredentialsValid(username2) && Validation.isCredentialsValid(password2)) {

                    Intent gotoSearch = new Intent(Login.this, Search.class);
                    startActivity(gotoSearch);
                } else {
                    username.setError(getResources().getString(R.string.login_invalid_credentials_message));
                    username.requestFocus();
                }
            }
        });
    }
}
