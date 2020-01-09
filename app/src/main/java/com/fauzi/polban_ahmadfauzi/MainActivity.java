package com.fauzi.polban_ahmadfauzi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    ImageButton gedung;
    Button keluar,download;

//    private static String file_url = "https://www.polban.ac.id/upload/2018/LAYOUTPOLBAN_2018.pdf";
    private static String file_url = "https://www.polban.ac.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gedung = findViewById(R.id.gedung);
        gedung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MyLocation.class);
                startActivity(intent);
            }
        });

        download = findViewById(R.id.download);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent link = new Intent();
               link.setAction(Intent.ACTION_VIEW);
               link.addCategory(Intent.CATEGORY_BROWSABLE);
               link.setData(Uri.parse(file_url));
               startActivity(link);
            }
        });


        keluar = findViewById(R.id.logout);
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             finish();
            }
        });

    }

}
