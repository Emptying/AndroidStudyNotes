package com.empty.activitysenddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edata,edata2,edata3,edata4,edata5;
    Button btn1,btn2,btn3;
    Intent i;
    TextView showback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        //EditText
        edata = (EditText) findViewById(R.id.editText);
        edata2 = (EditText) findViewById(R.id.editText2);
        edata3 = (EditText) findViewById(R.id.editText3);
        edata4 = (EditText) findViewById(R.id.editText4);
        edata5 = (EditText) findViewById(R.id.editText5);
        //TextView
        showback = (TextView) findViewById(R.id.showback);
        //
        i = new Intent(MainActivity.this,Activity2.class);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //第一种方式
                i.putExtra("data",edata.getText().toString());
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //第二种方式
                Bundle b = new Bundle();
                b.putString("name",edata2.getText().toString());
                b.putString("age",edata3.getText().toString());
                i.putExtras(b);
                startActivity(i);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //第三种方式
                i.putExtra("student",new Student("张三",Integer.parseInt(edata5.getText().toString())));
                //startActivity(i);
                startActivityForResult(i,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        showback.setText(data.getStringExtra("backdata"));
    }
}
