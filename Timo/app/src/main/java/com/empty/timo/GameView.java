package com.empty.timo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

/**
 * Created by cws10 on 2016/5/16.
 */
public class GameView extends View {
    private Bitmap timo;
    private int timoX;
    private int timoY;

    public void setTimoX(int X) {
        timoX = X;
    }

    public void setTimoY(int Y) {
        timoY = Y;
    }


    public GameView(Context context) {
        super(context);

    }

    //View呈现时自动调用的方法
    @Override
    protected void onDraw(Canvas canvas) {


        Log.i("test", "" + timoX + "," + timoY);

        //canvas 画布
        //在画布上面绘制图片
        timo = BitmapFactory.decodeResource(getResources(), R.drawable.timo1);
        canvas.drawBitmap(timo, timoX - timo.getWidth() / 2, timoY - timo.getHeight() / 2, null);

        super.onDraw(canvas);
    }
}
