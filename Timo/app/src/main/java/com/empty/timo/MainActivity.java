package com.empty.timo;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    GameView game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //新建提莫
        game = new GameView(this);
        setContentView(game);
        //窗口管理器
        WindowManager  windowManager = getWindowManager();
        Display display=windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int x=metrics.widthPixels;
        int y=metrics.heightPixels;
        //设置提莫初始位置
        game.setTimoX(x/2);
        game.setTimoY(y-80);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        game.setTimoX((int)event.getX());
        game.setTimoY((int) event.getY());
        game.invalidate();
        return super.onTouchEvent(event);
    }
}
