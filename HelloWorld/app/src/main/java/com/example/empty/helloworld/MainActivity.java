package com.example.empty.helloworld;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text= (TextView) findViewById(R.id.app_name);
        //在java代码中修改显示的内容
        //text.setText("Hello android");
        text.setText(R.string.hello);
        text.setTextColor(Color.BLUE);
        //text.setTextSize(10);
        //设置字体风格
        text.setTypeface(Typeface.DEFAULT,Typeface.ITALIC);
        //在logcat中输出text的类型
        Log.i("test",text.toString());
    }
}
