package com.example.empty.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by cws10 on 2016/4/12.
 */
public class MysqliteHelper extends SQLiteOpenHelper {
    public MysqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//重写onCreate 方法来建立一个表
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("tets","tableTest");
        db.execSQL("create table Student(id Integer primary key,name varchar,age Integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
