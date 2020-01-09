package com.fauzi.polban_ahmadfauzi.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.fauzi.polban_ahmadfauzi.Model.User;

import java.util.ArrayList;
import java.util.HashMap;


public class SQLiteHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "db_user";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "tableUsr";
    private static final String KEY_USERNAME = "username_usr";
    private static final String KEY_PASSWORD = "pass_usr";
    Context c;

    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS " + TABLE_USER  +
            "("+KEY_USERNAME+" TEXT PRIMARY KEY,"+
            KEY_PASSWORD+" TEXT );";

    public SQLiteHelper(Context c) {
        super(c, DATABASE_NAME,null, DATABASE_VERSION);
        this.c = c;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'" );
        onCreate(sqLiteDatabase);
    }

    public long addUser(User usr){
        SQLiteDatabase db = this.getWritableDatabase();
        //Creating content values;
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME,usr.getUsername());
        values.put(KEY_PASSWORD,usr.getPassword());
        //insert row
        long insert = db.insert(TABLE_USER,null,values);

        return insert;
    }

    public ArrayList<HashMap<String,String>> getAllUser() {
        ArrayList<HashMap<String,String>> userArrayList = new ArrayList<>();
        String username = "";
        String selectQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()) {
            do {
                HashMap<String,String> map = new HashMap<>();
                map.put(KEY_USERNAME,c.getString(0));
                map.put(KEY_PASSWORD,c.getString(1));

                userArrayList.add(map);
            } while(c.moveToNext());
        }

        return userArrayList;
    }

    public boolean autentikasi(User usr) {
        ArrayList<HashMap<String,String>> userArrayList;
        userArrayList = getAllUser();

        for (int i=0; i<userArrayList.size();i++){
            if((usr.getUsername().equals(userArrayList.get(i).get(KEY_USERNAME)))  &&
                    (usr.getPassword().equals(userArrayList.get(i).get(KEY_PASSWORD)))) {
                return true;
            }
        }

        return false;
    }
}
