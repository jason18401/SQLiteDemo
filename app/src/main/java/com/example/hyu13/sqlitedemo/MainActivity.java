package com.example.hyu13.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        try{
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);   //MODE_PRIVATE is only for your app
            //creating a table called users if it doesn't exist. Putting two variables in it name VARCHAR (AKA String) and age INT(3 for 3 digits, so max 999);
            //usually in SQL, capitalize everything but names of tables and variables
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rob', 34)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Jason', 26)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Chris', 25)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('JP', 30)");

            //get data out of the Database
            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);    //selected all(*) the users
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();
            while(c != null){
                Log.i("name", c.getString(nameIndex));
                Log.i("age", String.valueOf(c.getInt(ageIndex)));

                c.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        */

        //Query
        try{
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);   //MODE_PRIVATE is only for your app
            //creating a table called users if it doesn't exist. Putting two variables in it name VARCHAR (AKA String) and age INT(3 for 3 digits, so max 999);
            //usually in SQL, capitalize everything but names of tables and variables
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INT PRIMARY KEY)");
            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Rob', 34)");
            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Jason', 26)");
            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Chris', 25)");
            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('JP', 30)");

            //to update
            //myDatabase.execSQL("UPDATE newUsers SET age = 10 WHERE name = 'Rob'");

            //to delete
            //myDatabase.execSQL("DELETE FROM newUsers WHERE name = 'JP'");
            //myDatabase.execSQL("DELETE FROM newUsers WHERE id = 1");

            //get data out of the Database
            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers", null);    //selected all(*) the users
            /*
                WHERE name = 'Jason' AND age == 26
                WHERE name LIKE 'J%' search for value starting with J and anything after
                WHERE name LIKE '%o%' search for a value with a o in it
                WHERE name LIKE '%o%' LIMIT 1 limits to one person with a o
            */
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while(c != null){
                Log.i("name", c.getString(nameIndex));
                Log.i("age", String.valueOf(c.getInt(ageIndex)));
                Log.i("id", String.valueOf(c.getInt(idIndex)));

                c.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
