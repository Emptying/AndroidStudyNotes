package com.empty.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Bundle stu = getIntent().getExtras();
        Button baklogin = (Button) findViewById(R.id.baklogo);

        Student student = stu.getParcelable("student");
        TextView show = (TextView) findViewById(R.id.show);
        show.setText(student.getName());

        baklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShowActivity.this, LoginActivity.class);
                startActivity(intent);
                ShowActivity.this.finish();
            }
        });


    }
}
