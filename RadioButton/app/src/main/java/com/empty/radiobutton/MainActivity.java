package com.empty.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup gr,rg1;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
        gr = (RadioGroup) findViewById(R.id.gr);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        show = (TextView) findViewById(R.id.tvshow);
        gr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String str;
                if(checkedId==R.id.gir){
                    str="性别是女人";
                }else{
                    str="性别是男人";
                }
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int result=0;
                switch (checkedId){
                    case R.id.rb1:
                        result = 50;
                        break;
                    case R.id.rb2:
                        result = 100;
                        break;
                    case R.id.rb3:
                        result  = 150;
                        break;
                }
                Toast.makeText(MainActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                show.setText(""+result);
            }
        });
    }
}
