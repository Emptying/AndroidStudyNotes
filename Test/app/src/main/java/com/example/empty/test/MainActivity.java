package com.example.empty.test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView show = (TextView) findViewById(R.id.test);
        Log.i("tets","new");
        MysqliteHelper mydata =new MysqliteHelper(this,"student.db",null,1);
        SQLiteDatabase  db = mydata.getWritableDatabase();//获取可写数据库对象
        //db.execSQL("DELETE FROM student;");
        db.execSQL("insert into Student(name,age)values('妈的智障',18);");
        Log.i("tets","insert");
        db.close();
        String result=queryData(mydata);
        show.setText(result);


    }
    public String queryData(MysqliteHelper mydata){
        String result = "";
        SQLiteDatabase db = mydata.getReadableDatabase();
        Cursor cursor = db.query("Student",null,null,null,null,null,"id asc");
        int nameIndex = cursor.getColumnIndex("name");
        int ageIndex =  cursor.getColumnIndex("age");

        //cursor.getInt(cursor.getColumnIndex("age"));
        for(cursor.moveToFirst();!(cursor.isAfterLast());cursor.moveToNext()){
            result+=cursor.getString(nameIndex);//获得名字的索引位置
        }

        cursor.close();
        db.close();


        return result;
    }
}
