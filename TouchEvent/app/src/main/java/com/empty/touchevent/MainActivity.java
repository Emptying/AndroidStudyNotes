package com.empty.touchevent;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTest;
    EditText etTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTest = (TextView) findViewById(R.id.tvTest);
        etTest = (EditText) findViewById(R.id.editText);
        //只对物理键盘有效
        etTest.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i("TEST","onKey");
                String str="";
                switch(event.getAction()){
                    case KeyEvent.ACTION_DOWN:
                        str = "键盘按下";
                        break;
                    case KeyEvent.ACTION_UP:
                        str = "键盘抬起";
                        break;
                }
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                return false;
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String  str = "";
        Float x ;
        Float y ;
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                str = "按下";
                tvTest.setBackgroundColor(Color.GRAY);
                break;
            case MotionEvent.ACTION_UP:
                str = "抬起";
                tvTest.setBackgroundColor(Color.RED);
                break;
            case MotionEvent.ACTION_MOVE:
                str = "移动";
                x = event.getX();
                y = event.getY();
                str+="X="+x+","+"Y="+y;
                break;
        }
//        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
        tvTest.setText(str);

        return super.onTouchEvent(event);
    }
}
