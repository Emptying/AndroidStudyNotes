package com.empty.timo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class Option extends AppCompatActivity {
    Switch swBgMusic,swSound;
    RadioGroup rg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        swBgMusic = (Switch) findViewById(R.id.swBgMusic);
        swSound = (Switch) findViewById(R.id.swSound);
        rg = (RadioGroup) findViewById(R.id.rgtype);
        btn = (Button) findViewById(R.id.btnOpOK);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="";
                if(swBgMusic.isChecked()){
                    str+="背景音乐开\n";
                }
                if(swSound.isChecked()){
                    str+="游戏音效开\n";
                }
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.rbTimo1:
                        str+="提莫1";
                        break;
                    case R.id.rbTimo2:
                        str+="提莫2";
                        break;
                    case R.id.rbTimo3:
                        str+="提莫3";
                        break;
                }
                Toast.makeText(Option.this, str, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
