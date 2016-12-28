package com.github.qzavyer.clock;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// класс управления базой данных
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, "listDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE lists (" +
                "id INTEGER primary key autoincrement," +
                "name TEXT," +
                "sum REAL," +
                "progress NUMERIC," +
                "date NUMERIC" +
                ");");


        ContentValues cv = new ContentValues();
        cv.put("name","Вася");
        cv.put("sum","0");
        cv.put("progress","0");
        cv.put("date","0");
        db.insert("lists",null, cv);
        db.execSQL("CREATE TABLE items (" +
                "id INTEGER primary key autoincrement," +
                "list_id INTEGER," +
                "good_id INTEGER," +
                "count REAL," +
                "price REAL," +
                "sum REAL," +
                "is_exec NUMERIC" +
                ");");
        db.execSQL("CREATE TABLE goods (" +
                "id INTEGER primary key autoincrement," +
                "name TEXT," +
                "price REAL" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
