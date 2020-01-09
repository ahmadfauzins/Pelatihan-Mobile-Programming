package com.fauzi.polban_ahmadfauzi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fauzi.polban_ahmadfauzi.Helper.SQLiteHelper;
import com.fauzi.polban_ahmadfauzi.Model.User;


public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText etUsername, etPassword;
    Intent i;
    TextView btnRegis;
    SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegis = findViewById(R.id.btnRegisLogin);
        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(autentikasiLogin()){
                    Toast.makeText(Login.this,"Login Berhasil!", Toast.LENGTH_SHORT).show();
                    i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(Login.this,"Username / Password Salah !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });
    }

    public boolean autentikasiLogin(){
        User usr = new User(etUsername.getText().toString(),
                etPassword.getText().toString());
        return sqLiteHelper.autentikasi(usr);
    }
}
