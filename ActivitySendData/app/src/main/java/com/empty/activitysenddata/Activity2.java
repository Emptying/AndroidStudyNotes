package com.empty.activitysenddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView show,show2,show3;
    EditText edata;
    Button btnSendBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        //TextView
        show= (TextView) findViewById(R.id.textView);
        show2 = (TextView) findViewById(R.id.show2);
        show3 = (TextView) findViewById(R.id.show3);
        //EditText
        edata = (EditText) findViewById(R.id.editText6);
        //Button
        btnSendBack = (Button) findViewById(R.id.button4);

        //1
        show.setText(i.getStringExtra("data"));

       //2
/*        if(!b.getString("name").isEmpty()){
            show2.setText("姓名:"+b.getString("name")+"年龄:"+b.getString("age"));
        }*/

        //3
        //Student stu = (Student) i.getSerializableExtra("student");
        Student stu = (Student) i.getParcelableExtra("student");
        show3.setText(stu.toString());
        //sendBack

        btnSendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("backdata",edata.getText().toString());
                setResult(1,i);
                finish();
            }
        });






    }
}
