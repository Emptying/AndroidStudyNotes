package com.empty.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //Activity的声明周期图
    //https://developer.android.com/intl/zh-cn/reference/android/app/Activity.html

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("activity","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("activity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("activity","onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("activity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("activity","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("activity","onRestart");
    }
}
