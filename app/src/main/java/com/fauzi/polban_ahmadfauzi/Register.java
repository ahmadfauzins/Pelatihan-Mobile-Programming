package com.fauzi.polban_ahmadfauzi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fauzi.polban_ahmadfauzi.Helper.SQLiteHelper;
import com.fauzi.polban_ahmadfauzi.Model.User;


import java.util.ArrayList;
import java.util.HashMap;


public class Register extends AppCompatActivity {
    SQLiteHelper sqLiteHelper;
    Button btnRegistrasi;
    EditText etUsername,etPass,etEmail,etNama,etAsalSkl,etAlamat;
    ArrayList<HashMap<String,String>> user;
    private static final String KEY_USERNAME = "username_usr";
    private static final String KEY_PASSWORD = "pass_usr";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        btnRegistrasi = findViewById(R.id.btnRegis);
        etUsername = findViewById(R.id.etUsernameRegis);
        etPass = findViewById(R.id.etPasswordRegis);
        etEmail = findViewById(R.id.etEmailRegis);
        etNama = findViewById(R.id.etNamaRegis);
        sqLiteHelper = new SQLiteHelper(this);

        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrasi();
                Toast.makeText(Register.this,"Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }

    public void registrasi(){
        User usr = new User(etUsername.getText().toString(),
                etPass.getText().toString(),
                etEmail.getText().toString(),
                etNama.getText().toString());
        sqLiteHelper.addUser(usr);
    }
}
